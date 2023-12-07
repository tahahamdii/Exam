package com.example.examen.DAO.Controllers;

import com.example.examen.DAO.Entities.Bank;
import com.example.examen.Services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/banks")

public class BankController {

    @Autowired
    private BankService bankService;

    // Endpoint for adding multiple banks
    @PostMapping("/addBanks")
    public ResponseEntity<List<Bank>> addBanks(@RequestBody List<Bank> banks) {
        List<Bank> savedBanks = bankService.saveAllBanks(banks);
        return new ResponseEntity<>(savedBanks, HttpStatus.CREATED);
    }
}
