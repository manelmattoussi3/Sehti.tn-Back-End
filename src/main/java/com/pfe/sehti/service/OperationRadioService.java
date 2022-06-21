package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.entity.OperationRadio;
import com.pfe.sehti.repository.IOperationAnalyseRepository;
import com.pfe.sehti.repository.IOperationRadioRepository;

@Service
public class OperationRadioService implements IOperationRadioService{
	@Autowired
	IOperationRadioRepository opRadiorep;
		
		@Override
		public String AddOperationRadio(OperationRadio o) {
			opRadiorep.save(o);
			return "Radio est ajouté avec succé";
		}

		@Override
		public List<OperationRadio> findAllRadio() {
			
			return opRadiorep.findAll();
		}
}
