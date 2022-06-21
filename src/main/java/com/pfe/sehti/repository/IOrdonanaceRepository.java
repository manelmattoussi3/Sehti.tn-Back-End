package com.pfe.sehti.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.EtatOrdonance;
import com.pfe.sehti.entity.Ordonance;

@Repository
public interface IOrdonanaceRepository extends MongoRepository<Ordonance, String>{
	@Query("{'etat': ACTIVE}")
	public List<Ordonance>ConsulterOrdonancesActives();
	@Query("{'nouveaute': true}")
	public List<Ordonance>AccederNouveauxOrdonances();
}
