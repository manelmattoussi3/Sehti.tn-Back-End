package com.pfe.sehti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("lettreConfidentielle")
public class LettreConfidentielle implements Serializable{
	@Id
	private String idLettre;
	private String observation;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "GMT")
	private Date dateLettre;
	@DBRef()
	private DossierMedical dossier;
	

}
