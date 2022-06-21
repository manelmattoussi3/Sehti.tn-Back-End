package com.pfe.sehti.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("facture")
public class Facture {
	@Id
private String idFacture;
private float prixTotal;
private Date dateFacture;
}
