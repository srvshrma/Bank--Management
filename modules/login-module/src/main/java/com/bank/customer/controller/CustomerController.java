package com.bank.customer.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.model.Account;
import com.bank.common.handlers.ResponseHandlers;
import com.bank.common.model.ServiceResponse;
import com.bank.customer.model.LoginData;
import com.bank.customer.feign.AccountFeignController;
import com.bank.customer.feign.MutualFundControllerFeign;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import com.bank.fund.model.MutualFund;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;
	@Autowired
	AccountFeignController feign;
	@Autowired
	MutualFundControllerFeign mFeign;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse<Customer>> RegisterUser(@RequestBody Customer cust) {

	
  return new ResponseHandlers<Customer>().defaultResponse(service.createCustomer(cust), "Customer added successfully.", HttpStatus.CREATED);

	}
	@RequestMapping(value = "/{id}/account",method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse<Optional<Account>>> findById(@PathVariable(value = "id")int id){
		return new ResponseHandlers<Optional<Account>>().defaultResponse(feign.findById(id), HttpStatus.OK);
	}
	@RequestMapping(value = "/account/new", method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse<Account>> CreateAccount(@RequestBody Account data) {
		return new ResponseHandlers<Account>().defaultResponse(service.createAccount(data),"Account added successfully.", HttpStatus.CREATED);
		
	}
	/*@RequestMapping(value = "/{no}/account",method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse<Account>> findByAccountNo(@PathVariable(value = "no")String accountNo){
		return new ResponseHandlers<Account>().defaultResponse(feign.findByAccountNo(accountNo), HttpStatus.OK);
	}*/
	@RequestMapping(value = "/purchase/fund",method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse<MutualFund>> purchaseFunds(@RequestBody MutualFund data){
		return new ResponseHandlers<MutualFund>().defaultResponse(service.purchaseFund(data), "MutualFund purchased successfully.", HttpStatus.CREATED);
	}
	@RequestMapping(value = "/{id}/mutualfund",method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse<Optional<MutualFund>>> getById(@PathVariable(value="id") int id){
		return new ResponseHandlers<Optional<MutualFund>>().defaultResponse(mFeign.getById(id), HttpStatus.OK);
	}
	@RequestMapping("login/{userPan}/{password}")
	public ResponseEntity<ServiceResponse<LoginData>> loginFunctionality(@PathVariable String userPan,@PathVariable String password){
		LoginData data=new LoginData();
		Customer user=service.findByUserPan(userPan);
		data.setCustId(user.getCustId());
		data.setFirstName(user.getFirstName());
		data.setLastName(user.getLastName());
		data.setUserPan(user.getUserPan());
		data.setPhoneNo(user.getPhoneNo());
		data.setDob(user.getDob());
		data.setEmail(user.getEmail());
		if(password.equals(user.getPassword())) {
			return new ResponseHandlers().defaultResponse(data,"login successful", HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseHandlers().defaultResponse("login unsuccessful", HttpStatus.UNAUTHORIZED);
		}
	}

	
	}
