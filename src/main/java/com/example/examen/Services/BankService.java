package com.example.examen.Services;

import com.example.examen.DAO.Entities.*;
import com.example.examen.DAO.Repositories.BankRepository;
import com.example.examen.DAO.Repositories.CompteRepository;
import com.example.examen.DAO.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public List<Bank> saveAllBanks(List<Bank> banks) {
        return bankRepository.saveAll(banks);
    }

    public Bank ajouterBank(Bank bank) {
        return bankRepository.save(bank);

    }



    @Autowired
    private CompteRepository compteRepository; // Ensure you have a CompteRepository for data access
@Autowired
private TransactionRepository transactionRepository;
    // Other dependencies if needed

    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        // Implement the logic to add and assign the compte to the specified agenceBank
        // For simplicity, I assume you have a method in CompteRepository for saving compte
        // and setting the agenceBank property.

        // Example:
        compte.setAgence(agenceBank);
        return compteRepository.save(compte);
    }

    public List<String> ajouterTransactions(List<Transaction> transactions) {
        List<String> messages = new ArrayList<>();
        for (Transaction transaction : transactions) {
            messages.add(ajouterTransaction(transaction));
        }
        return messages;
    }

    public String ajouterTransaction(Transaction transaction) {
        // Add debug log
        System.out.println("Adding transaction: " + transaction);

        // Implement the logic to add a transaction, perform validations, and return a message
        // ...

        // Customize the logic based on your requirements
        return "Transaction added successfully.";
    }



    public String ajouterVirement(Transaction transaction) {
        transaction.setExpediteur(compteRepository.findByCode(transaction.getExpediteur().getCode()));
        transaction.setDestinataire(compteRepository.findByCode(transaction.getDestinataire().getCode()));
        if (transaction.getTypeT().equals(TypeTransaction.VIREMENT) && (transaction.getExpediteur().getTypeC().equals(TypeCompte.EPARGNE))) {
            return "On ne peut pas faire un virement à partir d’un compte épargne";
        } else {
            if ( !(transaction.getExpediteur().getTypeC().equals(TypeCompte.EPARGNE)) && (transaction.getExpediteur().getSolde() < (transaction.getMontant() + 3))||(transaction.getExpediteur().getTypeC().equals(TypeCompte.EPARGNE)) && (transaction.getExpediteur().getSolde() < transaction.getMontant())) {

                return "On ne peut pas faire un virement : Solde insuffisant";
            } else {
                Compte expediteur = compteRepository.findByCode(transaction.getExpediteur().getCode());
                Compte destinataire = compteRepository.findByCode(transaction.getDestinataire().getCode());
                expediteur.setSolde(expediteur.getSolde() - (transaction.getMontant() + 3));
                destinataire.setSolde(destinataire.getSolde() + transaction.getMontant());
                transaction.setDateTransaction(LocalDate.now());

                compteRepository.save(expediteur);
                compteRepository.save(destinataire);
                transactionRepository.save(transaction);
                return "VIREMENT de "+transaction.getMontant()+" DT de compte "+expediteur.getIdCompte()+" vers le compte "+destinataire.getIdCompte()+" approuvée avec succès";
            }
        }
    }

    // Add more service methods as needed
}
