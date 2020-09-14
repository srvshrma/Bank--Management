package com.bank.transaction.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.account.model.Account;
import com.bank.common.exception.BankException;
import com.bank.model.Bank;
import com.bank.model.Payment;
import com.bank.transaction.config.BanksProperties;
@Service
public class TransactionServiceImpl implements TransationService{

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BanksProperties banks;
	
	public Payment checkPayment(Account account) {
		Bank userBank = banks.getBanksMappings().get(account.getBankName().toUpperCase());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));        
		messageConverters.add(converter); 
		restTemplate.setMessageConverters(messageConverters); 
		Payment receivedPayment = null;
		try {
			ResponseEntity<Payment> exchange = restTemplate.exchange(userBank.getFullUrl(), HttpMethod.GET, entity, Payment.class);
			
			if(exchange.getStatusCode().is2xxSuccessful()) {
				receivedPayment = Optional.ofNullable(exchange.getBody()).get();
				if(!Objects.isNull(receivedPayment.getFailure()) && receivedPayment.getFailure().getFailureCode() != 0) {
					throw new BankException(HttpStatus.INTERNAL_SERVER_ERROR, receivedPayment.getFailure().getMessage());
				}
			}else {
				throw new BankException(HttpStatus.SERVICE_UNAVAILABLE, "Gateway Down!!!");
			}
		}catch(Exception ex) {
			throw new BankException(HttpStatus.BAD_GATEWAY, "Gateway Down!!!");
		}
		return Optional.of(receivedPayment)
				.filter(pay->!Objects.isNull(pay))
				.orElseThrow(()-> new BankException(HttpStatus.INTERNAL_SERVER_ERROR, "Gateway Down!!!"));
	} 
	}


