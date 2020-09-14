package com.bank.fund.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.common.handlers.ResponseHandlers;
import com.bank.common.model.ServiceResponse;
import com.bank.fund.model.MutualFund;
import com.bank.fund.service.MutualFundService;

@RestController
public class MutualFundController {

	@Autowired
	MutualFundService service;
	
	@PostMapping("/purchase/fund")
	public ResponseEntity<ServiceResponse<MutualFund>> createFunds(@RequestBody MutualFund data) {
		return new ResponseHandlers().defaultResponse(service.createFund(data), "Invested to mutual fund.", HttpStatus.CREATED);
	}
	@GetMapping("/{id}/mutualfund")
	public ResponseEntity<ServiceResponse<Optional<MutualFund>>> getById(@PathVariable(value="id") int id){
		return new ResponseHandlers().defaultResponse(service.findById(id));
	}
	
}
