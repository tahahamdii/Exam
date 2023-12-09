package com.example.examen.DAO.Repositories;

import com.example.examen.DAO.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    // Add any custom methods for CompteRepository if needed
    Compte findByCode(long code);
}
