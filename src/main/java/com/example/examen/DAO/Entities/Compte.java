package com.example.examen.DAO.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table(name = "compte")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompte;
    @Enumerated(EnumType.STRING)
    @Column(name = "typeC")
    private TypeCompte typeC;
    @Column(name = "solde")
    private double solde;

    public Compte() {

    }

    public void setAgence(String agenceBank) {
    }
}
