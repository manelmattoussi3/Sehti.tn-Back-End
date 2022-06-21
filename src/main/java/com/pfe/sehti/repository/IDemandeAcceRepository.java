package com.pfe.sehti.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.EtatAcce;

@Repository
public interface IDemandeAcceRepository extends MongoRepository<DemandeAcce, String>{

	@Query("{'praticien.idPraticien': ?0}")
	public List<DemandeAcce> findByPraticien(String idPraticien);
	
	@Query("{'dossierMedical.idDossier': ?0}")
	public List<DemandeAcce> findByDossierMedical(String idDossier);
	@Query("{'etat': PERMANENT}")
	public List<DossierMedical> findByEtatDemande();
	
}
