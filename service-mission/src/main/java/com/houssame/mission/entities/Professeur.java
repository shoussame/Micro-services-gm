package com.houssame.mission.entities;

import java.util.Collection;

import lombok.Data;

@Data
public class Professeur {
	private String id;
	private String username;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String DateDeNaissance;
	private Collection<Mission> missions;
	public Professeur(String nom, String prenom, String email, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}
}