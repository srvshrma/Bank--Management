package com.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.fund.dao.MutualFundRepository;
import com.bank.fund.model.MutualFund;
import com.bank.fund.service.MutualFundServiceImpl;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutualFundServiceTest {

	@Mock
	MutualFundRepository repo;
	@InjectMocks
	MutualFundServiceImpl service;
	
	LocalDate date=LocalDate.now();
	MutualFund fund=new MutualFund(1, "987654", "Mutual", 98000, date);
	
	@Test
	public void testCreateAccount() {
		Mockito.when(repo.save(fund)).thenReturn(fund);
		assertEquals(fund, service.createFund(fund));
	}
	@Test
	public void testGetById() {
		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(fund));
		Optional<MutualFund> stu = service.findById(1);
		assertTrue(stu.isPresent());
	}
}
