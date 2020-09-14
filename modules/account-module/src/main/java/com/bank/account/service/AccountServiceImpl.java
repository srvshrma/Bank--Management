package com.bank.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.dao.AccountRepository;
import com.bank.account.model.Account;
@Service
public class AccountServiceImpl implements AccountService {
@Autowired
AccountRepository repo;
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return repo.save(account);
	}

	@Override
	public Optional<Account> getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	/*@Override
	public Account findByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return repo.findByAccountNo(accountNo);
	}*/

	@Override
	public Account updateAccountById(Account account) {
		// TODO Auto-generated method stub
		return repo.save(account);
	}

	@Override
	public void deleteAccountById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
