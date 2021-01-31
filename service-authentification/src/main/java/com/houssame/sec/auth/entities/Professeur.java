package com.houssame.sec.auth.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.houssame.sec.auth.utilities.prototype.Mission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Professeur extends AppUser{
	@Transient private Collection<Mission> missions;
	
	public Collection<Mission> getMissions() {
		return missions;
	}
	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}
	public Professeur(String username, String password, String nom, String prenom, String email,
			String dateDeNaissance) {
		super(username, password, nom, prenom, email, dateDeNaissance);
	}
	
}
