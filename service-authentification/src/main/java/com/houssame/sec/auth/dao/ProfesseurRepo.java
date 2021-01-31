package com.houssame.sec.auth.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.houssame.sec.auth.entities.Professeur;

public interface ProfesseurRepo extends JpaRepository<Professeur, String>{
	Professeur findByUsername(String username);
}
