package com.pfe.sehti.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("medicament")
public class Medicament {
	@Id
private String idMedicament;
private String name;
private ClasseMedical classe;
@DBRef()
private List<Prescription>prescriptions;
}
