package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.Praticien;

@Repository
public interface IPraticienRepository extends MongoRepository<Praticien, String>{

}
