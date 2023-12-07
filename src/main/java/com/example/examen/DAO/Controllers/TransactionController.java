package com.example.examen.DAO.Controllers;

import com.example.examen.DAO.Entities.Transaction;
import com.example.examen.Services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private BankService transactionService;

    // Endpoint for adding 4 transactions
    @PostMapping("/ajouterTransactions")
    public ResponseEntity<List<String>> ajouterTransactions(@RequestBody List<Transaction> transactions) {
        List<String> messages = transactionService.ajouterTransactions(transactions);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
















    // Endpoint for adding a virement transaction
    @PostMapping("/ajouterVirement")
    public ResponseEntity<String> ajouterVirement(@RequestBody Transaction transaction) {
        String message = transactionService.ajouterVirement(transaction);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Add more controller methods as needed
}
