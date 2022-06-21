package com.pfe.sehti.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("operationRadio")
public class OperationRadio {
	@Id
	private String idOperation;
	private String codeRadio;
	private String observation;
	//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "GMT")
	private Date dateOperation;
	private String motif;
	private String resultat;
	private String etablissement;
	private ExamenRadio type;
	private etatAnalyse etat;
}
                     