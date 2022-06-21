package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.OperationAnalyse;

public interface IOperationAnalyseService {
public String AddOperationAnalyse(OperationAnalyse o);
public List<OperationAnalyse> findAnalyses();
}
