package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.OperationRadio;

public interface IOperationRadioService {
	public String AddOperationRadio(OperationRadio o);
	public List<OperationRadio> findAllRadio();
}
