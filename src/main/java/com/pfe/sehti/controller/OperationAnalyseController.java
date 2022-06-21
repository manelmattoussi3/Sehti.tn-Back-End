package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.service.IOperationAnalyseService;
@CrossOrigin(origins = "*")
@RestController
public class OperationAnalyseController {
@Autowired
IOperationAnalyseService opserv;
@PostMapping("/AddOperationAnalyse")
public String AddOperationAnalyse(@RequestBody OperationAnalyse o) {
	return opserv.AddOperationAnalyse(o);
}
@GetMapping("/findAnalyses")

public List<OperationAnalyse> findAnalyses() {
	return opserv.findAnalyses();
}
}
