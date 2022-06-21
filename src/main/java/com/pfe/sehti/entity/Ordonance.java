package com.pfe.sehti.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("ordonance")
public class Ordonance {
	@Id
	private String idOrdonance;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "GMT")
	private Date dateOrdonance;
	private int numOrdonance;
	private EtatOrdonance etat;
	private boolean nouveaute;
	
	@DBRef()
	private List<Prescription>prescriptions;
	private Consultation consultation;

}
