package com.bank.account.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
import com.bank.common.handlers.ResponseHandlers;
import com.bank.common.model.ServiceResponse;

@RestController
public class AccountController {
	
	@Autowired
	AccountService service;
	@PostMapping("/account/new")
	public ResponseEntity<ServiceResponse<Account>> CreateAccount(@RequestBody Account data) {
		return new ResponseHandlers<Account>().defaultResponse(service.createAccount(data), "Account added successfully.", HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}/account")
	public ResponseEntity<ServiceResponse<Optional<Account>>> findById(@PathVariable(value = "id")int id) {
		return new ResponseHandlers<Optional<Account>>().defaultResponse(service.getById(id));
	}
/*	@GetMapping("/{no}/account")
	public ResponseEntity<ServiceResponse<Account>> findByAccountNo(@PathVariable(value = "no")String accountNo) {
		return new ResponseHandlers<Account>().defaultResponse(service.findByAccountNo(accountNo));
	}*/
	@PutMapping("/{id}/account/update")
	public ResponseEntity<ServiceResponse<Account>> updateAccount(Account account,@PathVariable(value = "id") int id)
	{
		Account update = new Account(id, account.getAccountNo(),account.getIfsc(), account.getBankName(),account.getMicrCode(), account.getAmount());
		return new ResponseHandlers<Account>().defaultResponse(service.updateAccountById(update), "Account updated successfully.");
	}
	

	@DeleteMapping("/{id}/account/delete")
	public void deleteById(@PathVariable(value = "id") int id) {
		service.deleteAccountById(id);
	}
}
