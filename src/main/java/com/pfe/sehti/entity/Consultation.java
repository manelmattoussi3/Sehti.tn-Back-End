package com.pfe.sehti.entity;

import java.util.Date;

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
@Document("consultation")
public class Consultation {
	@Id
private String idConsultation;
private String lieu;
private Date dateConsultation;
private String observation;
private EtatConsultation etat;
@DBRef()
private Certificat certificat;
@DBRef()
private Ordonance ordonance;
}
