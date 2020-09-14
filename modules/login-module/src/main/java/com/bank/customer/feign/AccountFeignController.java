package com.bank.customer.feign;

import java.util.Optional;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.model.Account;
import com.bank.common.model.ServiceResponse;


@FeignClient(value="account-service",url = "http://localhost:8081",fallbackFactory =AccountFallBack.class)
public interface AccountFeignController {
	
	@LoadBalanced
	@RequestMapping(value = "/{id}/account",method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse<Optional<Account>>> findById(@PathVariable(value = "id")int id);
	@LoadBalanced
	@RequestMapping(value = "/account/new",method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse<Account>> CreateAccount(@RequestBody Account data);
	/*@LoadBalanced
	@RequestMapping(value = "/{no}/account",method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse<Account>> findByAccountNo(@PathVariable(value = "no")String accountNo);*/
	@LoadBalanced
	@RequestMapping(value = "/{id}/account/update",method = RequestMethod.PUT)
	public ResponseEntity<ServiceResponse<Account>> updateAccount(Account account,@PathVariable(value = "id") int id);
	@LoadBalanced
	@RequestMapping(value = "/{id}/account/delete",method = RequestMethod.DELETE)
	public void deleteAccountById(int id);
}
