package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.LettreConfidentielle;

@Repository
public interface ILettreConfidentielleRepository extends MongoRepository<LettreConfidentielle,String>{

}
