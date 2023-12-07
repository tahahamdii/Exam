package com.example.examen.DAO.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    @Column(name = "idBank")
    private long idBank ;
    @Column(name = "nom")
    private String nom;
    @Column(name = "agence")
    private String agence;
    @Column(name = "adresse")
    private String adresse;

    @OneToMany(cascade = ALL)
    private Set<Compte> comptes;


    public Bank() {

    }
}
