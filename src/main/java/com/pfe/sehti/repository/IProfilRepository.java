package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.Profil;

@Repository
public interface IProfilRepository extends MongoRepository<Profil,String>{

}
