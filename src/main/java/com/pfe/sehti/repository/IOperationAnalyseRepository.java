package com.pfe.sehti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.OperationAnalyse;

@Repository
public interface IOperationAnalyseRepository extends MongoRepository<OperationAnalyse, String>{

}
