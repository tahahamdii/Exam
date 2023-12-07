package com.example.examen.DAO.Controllers;

import com.example.examen.DAO.Entities.Compte;
import com.example.examen.Services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private BankService compteService;

    // Endpoint for adding and assigning accounts to a bank branch
    @PostMapping("/ajouterEtAffecter/{agenceBank}")
    public ResponseEntity<Compte> ajouterCompteEtAffecterAAgence(@RequestBody Compte compte,@PathVariable String agenceBank) {
        Compte addedCompte = compteService.ajouterCompteEtAffecterAAgence(compte, agenceBank);
        return new ResponseEntity<>(addedCompte, HttpStatus.CREATED);
    }

    // Add more controller methods as needed
}
