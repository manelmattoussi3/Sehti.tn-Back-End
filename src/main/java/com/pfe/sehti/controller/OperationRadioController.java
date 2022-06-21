package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.OperationRadio;
import com.pfe.sehti.service.IOperationRadioService;


@RestController
public class OperationRadioController {
	@Autowired
	IOperationRadioService opRadioserv;
	@PostMapping("/AddOperationRadio")
	public String AddOperationRadio(@RequestBody OperationRadio o) {
		return opRadioserv.AddOperationRadio(o);
	}
	@GetMapping("/findAllRadio")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<OperationRadio> findAllRadio() {
		return opRadioserv.findAllRadio();
	}
}
