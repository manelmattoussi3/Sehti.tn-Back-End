package com.pfe.sehti.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Document(collection = "profil")
public class Profil implements Serializable{

    @Id
   private String idProfil;

    private String description;

   private RoleType role;

    @DBRef()
    private AppUser user;
    

}
