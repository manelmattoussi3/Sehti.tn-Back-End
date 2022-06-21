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
@Document("certificat")
public class Certificat {
	@Id
private String idCertificat;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "GMT")
private Date dateCertificat;
private String contenu;
}
