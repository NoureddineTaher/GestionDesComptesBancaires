package com.noureddine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noureddine.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
