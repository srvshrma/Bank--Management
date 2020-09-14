package com.bank.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.account.model.Account;
import com.bank.common.model.ServiceResponse;
import com.bank.customer.feign.AccountFeignController;
import com.bank.customer.feign.MutualFundControllerFeign;
import com.bank.customer.dao.CustomerRepository;
import com.bank.customer.model.Customer;
import com.bank.fund.model.MutualFund;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;
	@Autowired
	AccountFeignController accountFeign;
	@Autowired
	MutualFundControllerFeign fundFeign;
	
	//@Autowired
	//MutualFundControllerFeign fundFeign;
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}

	@Override
	public Optional<Customer> getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Customer findByUserPan(String userPan) {
		// TODO Auto-generated method stub
		return repo.findByUserPan(userPan);
	}
	
	@Override
	public ResponseEntity<ServiceResponse<Account>> createAccount(Account data) {
	//	if(accountFeign.findByAccountNo(data.getAccountNo()).getBody().getData() !=null) {
		//	accountFeign.CreateAccount(data);
		//}
		return accountFeign.CreateAccount(data);

		
	}

	@Override
	public ResponseEntity<ServiceResponse<MutualFund>> purchaseFund(MutualFund data) {
		// TODO Auto-generated method stub
		return fundFeign.createFunds(data);
	}

	
}
