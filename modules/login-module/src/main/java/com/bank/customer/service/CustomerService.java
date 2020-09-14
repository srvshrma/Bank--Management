package com.bank.customer.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.bank.account.model.Account;
import com.bank.common.model.ServiceResponse;
import com.bank.customer.model.Customer;
import com.bank.fund.model.MutualFund;

public interface CustomerService {
	
	Customer createCustomer(Customer customer);
	ResponseEntity<ServiceResponse<Account>> createAccount(Account data);
	Optional<Customer> getById(int id);
	Customer findByUserPan(String userPan);
	ResponseEntity<ServiceResponse<MutualFund>> purchaseFund(MutualFund data);
	
}
