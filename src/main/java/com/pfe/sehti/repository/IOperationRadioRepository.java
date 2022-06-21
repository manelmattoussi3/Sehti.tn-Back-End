package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.OperationRadio;

@Repository
public interface IOperationRadioRepository extends MongoRepository<OperationRadio, String>{

}
