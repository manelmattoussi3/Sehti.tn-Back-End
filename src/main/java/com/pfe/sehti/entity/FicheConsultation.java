package com.pfe.sehti.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("ficheConsultation")
public class FicheConsultation {
	@Id
private String idFiche;
private String observation;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
private Date dateCreation;
@DBRef()
private OperationRadio radio;
@DBRef()
private Consultation consultation;
@DBRef()
private OperationAnalyse analyse;

@DBRef()
private DossierMedical dossier;
}
