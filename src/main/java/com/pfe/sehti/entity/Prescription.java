package com.pfe.sehti.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("prescription")
public class Prescription {
	@Id
	private String idPre;
	private Date dateDebut;
	private Date dateFin;
	private int dose;
	private int nbrFois;
	private String unite;
	private EtatMedicament etat;
	@DBRef()
	private Medicament medicament;
	@DBRef()
	private Ordonance ordonance;
	

}

