package com.bank.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bank.account.controller.AccountController;
import com.bank.account.model.Account;
import com.bank.account.service.AccountServiceImpl;
import com.bank.common.model.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest
public class AccountControllerTest {
	@InjectMocks
	AccountController controller;
	@Mock
	AccountServiceImpl service;

	private String bankName="Hdfc";
	Account account = new Account(1,"123456789987654", "UBIN9090900", bankName, 9988, 98000);
	@Test
	public void testCreateAccount() {

		when(service.createAccount(account)).thenReturn(account);
		ResponseEntity<ServiceResponse<Account>> response=controller.CreateAccount(account);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
}
	
	@Test
	public void testFindById() throws Exception {

		Mockito.when(service.getById(Mockito.anyInt()))
		.thenReturn(Optional.of(account));
		ResponseEntity<ServiceResponse<Optional<Account>>> response = controller.findById(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
