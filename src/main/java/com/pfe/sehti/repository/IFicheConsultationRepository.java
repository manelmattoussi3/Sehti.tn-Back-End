package com.pfe.sehti.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.FicheConsultation;

@Repository
public interface IFicheConsultationRepository extends MongoRepository<FicheConsultation, String>{
	@Query("{'dossier.idDossier':?0}")
	public FicheConsultation findByDossier(String idDossier);
	@Query("{'dossier.patient.idPatient':?0}")
	public List<FicheConsultation> findByPatient(String idPatient);
}
