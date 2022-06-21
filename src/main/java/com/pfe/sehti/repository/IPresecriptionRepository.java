package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.Prescription;

@Repository
public interface IPresecriptionRepository extends MongoRepository<Prescription, String>{

}
