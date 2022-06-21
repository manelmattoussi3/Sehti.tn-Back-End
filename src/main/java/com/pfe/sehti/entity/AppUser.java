package com.pfe.sehti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("appUser")
public class AppUser implements Serializable {
	private String idUser;
	private Date dateBirth;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String password;
	private String genre;
	private String image;
	private String tel;
	@DBRef()
	private Profil profil;
	

}
