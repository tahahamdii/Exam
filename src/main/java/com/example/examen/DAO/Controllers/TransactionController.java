package com.example.examen.DAO.Controllers;

import com.example.examen.DAO.Entities.Transaction;
import com.example.examen.Services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.examen.Services.IBankService;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    IBankService IBankService;

    @Autowired
    private BankService transactionService;

    // Endpoint for adding 4 transactions
    @PostMapping("/ajouterTransactions")
    public ResponseEntity<List<String>> ajouterTransactions(@RequestBody List<Transaction> transactions) {
        List<String> messages = transactionService.ajouterTransactions(transactions);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }


    @PostMapping("addVirement")
    public String ajouterVirement(@RequestBody Transaction transaction){
        return IBankService.ajouterVirement(transaction);
    }















    // Add more controller methods as needed
}
