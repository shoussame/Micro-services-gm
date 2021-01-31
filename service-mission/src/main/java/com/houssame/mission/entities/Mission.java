package com.houssame.mission.entities;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.houssame.mission.utilities.filestorage.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Mission {
	@Id @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String dateDemande;
	private String dateDepart;
	private String dateRetour;
	private String statutActuel;
	private boolean validationDirecteur;
	private boolean validationDirectAdj;
	private boolean validationComptable;
	private String profID;
	@Transient
	private Professeur professeur;
	@OneToMany(mappedBy = "mission",fetch = FetchType.LAZY)
	private Collection<FileDb> files = new ArrayList<>();
	private String ville;
	private boolean statut;
	
	private String motif;
	private long budget;
	public Mission(String id,String dateDemande, String dateDepart, String dateRetour, String destination, boolean statut) {
		super();
		this.id  = id;
		this.dateDemande = dateDemande;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.ville = destination;
		this.statut = statut;
		this.statutActuel = "EN COURS";
		this.validationComptable = false;
		this.validationDirectAdj = false;
		this.validationDirecteur = false;
	}
	
	public Mission(String dateDemande, String dateDepart, String dateRetour, Professeur personne,
			String destination, boolean statut) {
		super();
		this.dateDemande = dateDemande;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.professeur = personne;
		this.ville = destination;
		this.statut = statut;
	}

	public Mission(String id, String dateDemande, String dateDepart, String dateRetour, Professeur personne,
			String destination, boolean statut) {
		super();
		this.id = id;
		this.dateDemande = dateDemande;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.professeur = personne;
		this.ville = destination;
		this.statut = statut;
	}

}


