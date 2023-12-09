package com.example.examen.DAO.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Table(name = "transaction")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction ;
    @Column(name = "montant")
    private double montant ;
    @Enumerated(EnumType.STRING)
    @Column(name = "typeT")
    private TypeTransaction typeT;
    @Column(name = "datetransaction")
    private LocalDate dateTransaction;
    @ManyToOne
    private Compte destinataire;
    @ManyToOne
    private Compte expediteur;


    public Transaction() {

    }
}
