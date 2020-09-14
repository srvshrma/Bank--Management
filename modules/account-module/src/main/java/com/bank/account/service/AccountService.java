package com.bank.account.service;

import java.util.Optional;

import com.bank.account.model.Account;


public interface AccountService {
	
	Account createAccount(Account account);
	Optional<Account> getById(int id);
	//Account findByAccountNo(String accountNo);
	Account updateAccountById(Account account);
	public void deleteAccountById(int id);
}
