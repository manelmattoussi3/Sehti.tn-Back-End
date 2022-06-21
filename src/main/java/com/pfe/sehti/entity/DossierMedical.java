package com.pfe.sehti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("dossierMedical")
public class DossierMedical implements Serializable{
	@Id
	private String idDossier;
	private int numDossier;
	
	private Date dateCreation;
	private String codeAcce;
	private String observation;
	private float poids;
	private float taille;
	private GroupSanguin sang;
	private int perimetreCarnien;
	@DBRef()
	private Patient patient;
	@JsonManagedReference
	@DBRef()
	private List<DemandeAcce>demandesacces;

	@DBRef()
	private List<FicheConsultation> fiche;
	
	@DBRef()
	private List<LettreConfidentielle>lettres;
	
}

