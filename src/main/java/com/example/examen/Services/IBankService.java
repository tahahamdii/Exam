package com.example.examen.Services;

import com.example.examen.DAO.Entities.Bank;
import com.example.examen.DAO.Entities.Compte;
import com.example.examen.DAO.Entities.Transaction;

public interface IBankService {
    public Bank ajouterBank(Bank bank);
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
    public String ajouterVirement(Transaction transaction);
}
