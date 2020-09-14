package com.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.account.model.Account;
import com.bank.common.model.ServiceResponse;
import com.bank.customer.controller.CustomerController;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest
public class CustomerControllerTest {

	@InjectMocks
	CustomerController controller;
	@Mock
	CustomerServiceImpl service;

	LocalDate date=LocalDate.of(1997, 11, 05);
	Customer cust=new Customer(1, "987123", "Saurav", "Sharma", "HDCPS9195A", "saurav@1", "saurav@gmail.com", "8053717953", date);
	
	@Test
	public void testCreateCustomer() {

		when(service.createCustomer(cust)).thenReturn(cust);
		ResponseEntity<ServiceResponse<Customer>> response=controller.RegisterUser(cust);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
}
	
}
