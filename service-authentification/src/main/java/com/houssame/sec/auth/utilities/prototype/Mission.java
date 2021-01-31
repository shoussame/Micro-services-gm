package com.houssame.sec.auth.utilities.prototype;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Transient;

import com.houssame.sec.auth.entities.Professeur;

import lombok.Data;


@Data
public class Mission {
	private String id;
	private String dateDemande;
	private String dateDepart;
	private String dateRetour;
	private String statutActuel;
	private boolean validationDirecteur;
	private boolean validationDirectAdj;
	private boolean validationComptable;
	private String professeurID;
	private Professeur professeur;
	@Transient
	private Collection<FileDb> files = new ArrayList<>();
	private String ville;
	private boolean statut;
	
	private String motif;
	private long budget;
}
