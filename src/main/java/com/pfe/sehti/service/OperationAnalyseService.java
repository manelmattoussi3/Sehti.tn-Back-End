package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.repository.IOperationAnalyseRepository;

@Service
public class OperationAnalyseService implements IOperationAnalyseService{
@Autowired
IOperationAnalyseRepository oprep;
	@Override
	public String AddOperationAnalyse(OperationAnalyse o) {
		oprep.save(o);
		return "Analyse est ajouté avec succé";
	}
	@Override
	public List<OperationAnalyse> findAnalyses() {
		
		return oprep.findAll();
	}


}
