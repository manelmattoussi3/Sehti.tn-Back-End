package com.pfe.sehti.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.Patient;

@Repository
public interface IDossierMedicalRepository extends MongoRepository<DossierMedical, String>{
	 @Query("{'patient.idPatient': ?0}")
public List<DossierMedical> findByPatient(String idPatient);
public DossierMedical findByCodeAcce (String codeAcce);
@Query("{'FicheConsultation.idFiche': ?0}")
public DossierMedical findByFicheConsultation(int idFiche);
@Query("{'demandesacces':null}")
public List<DossierMedical> findAllDossierWithoutDemandes();
@Query("{'demandesacces':{$ne:null}}")

public List<DossierMedical> findAllDossierWithDemandes();

}
