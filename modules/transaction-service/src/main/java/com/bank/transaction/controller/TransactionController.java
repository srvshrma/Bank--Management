package com.bank.transaction.controller;

import java.util.List;

import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.model.Account;
import com.bank.common.handlers.ResponseHandlers;
import com.bank.common.model.ServiceResponse;
import com.bank.model.Bank;
import com.bank.model.Payment;
import com.bank.model.Transaction;
import com.bank.transaction.config.BanksProperties;


@RestController
public class TransactionController {

	@Autowired
	BanksProperties banksProperties;
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value="/active-banks", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<String>>> getBanks() {
		return new ResponseHandlers<List<String>>().defaultResponse(banksProperties.getActiveBanks());
		
	}

	@RequestMapping(value="/active-banks-details", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<Bank>>> getBanksDetails() {
		return new ResponseHandlers<List<Bank>>().defaultResponse(banksProperties.getBanks());
	}
	
	public ResponseEntity<ServiceResponse<Transaction>> makeTransaction(Account account, String mutualFund) {
		//Payment payment =  transactionService.checkPayment();
		return new ResponseHandlers<Transaction>().defaultResponse(Transaction.builder().mutualFund(mutualFund).build(), "Purchase successful.");
	}

}
