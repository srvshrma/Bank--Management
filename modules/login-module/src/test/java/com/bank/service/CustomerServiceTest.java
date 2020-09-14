package com.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.account.model.Account;
import com.bank.customer.dao.CustomerRepository;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerServiceImpl;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	@Mock
	CustomerRepository repo;
	@InjectMocks
	CustomerServiceImpl service;
	LocalDate date=LocalDate.of(1997, 11, 05);
	Customer cust=new Customer(1, "987123", "Saurav", "Sharma", "HDCPS9195A", "saurav@1", "saurav@gmail.com", "8053717953", date);
	@Test
	public void testCreateCustomer() {
		Mockito.when(repo.save(cust)).thenReturn(cust);
		assertEquals(cust,service.createCustomer(cust));
	}
	
	@Test
	public void testGetById() {
		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(cust));
		Optional<Customer> stu = service.getById(1);
		assertTrue(stu.isPresent());
	}
}
