package com.pfe.sehti.entity;

import java.io.Serializable;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("praticien")
public class Praticien extends Profil {
	
	private String idPraticien;
	private PraticienType type;
	private String lieuExercice;
	private String ville;
	private boolean disponibilite;
	private String specialite;
	private FilierePraticien filiere;
//	@DBRef()
//	private List<LettreConfidentielle>lettres;
	@JsonIgnore
	@DBRef()
	private List<DemandeAcce> demandesacces;

}
