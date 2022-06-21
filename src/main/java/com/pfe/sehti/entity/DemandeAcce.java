package com.pfe.sehti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("demandeAcce")
public class DemandeAcce  implements Serializable{
	@Id
	private String idDemande;
	private EtatAcce etat;
	private Date dateCreation;
	@DBRef()
	private Praticien praticien;
	@JsonBackReference
	@DBRef()
	private DossierMedical dossierMedical;                
	
}
