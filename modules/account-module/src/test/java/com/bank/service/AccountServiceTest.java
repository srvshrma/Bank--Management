package com.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.account.dao.AccountRepository;
import com.bank.account.model.Account;
import com.bank.account.service.AccountServiceImpl;
@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

	@Mock
	AccountRepository repository;
	
	@InjectMocks
	AccountServiceImpl accountservice;
	
	private String bankName="Hdfc";
	Account account = new Account(1,"123456789987654", "UBIN9090900", bankName, 9988, 98000);
	@Test
	public void testCreateAccount() {
		Mockito.when(repository.save(account)).thenReturn(account);
		assertEquals(account, accountservice.createAccount(account));
	}
	
	@Test
	public void testGetById() {
		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(account));
		Optional<Account> stu = accountservice.getById(1);
		assertTrue(stu.isPresent());
	}
/*	@Test
	public void testGetByAccountNo() {
		Mockito.when(repository.findByAccountNo(Mockito.anyString())).thenReturn(account);
		 accountservice.findByAccountNo("123456789987654");
	}*/
	@Test
	public void testUpdateAccountById() {
		Mockito.when(repository.save(account)).thenReturn(account);
		assertEquals(account, accountservice.updateAccountById(account));
	}
	
}
