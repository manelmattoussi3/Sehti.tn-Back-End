package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.Certificat;

@Repository
public interface ICertificatRepository extends MongoRepository<Certificat,String>{

}
