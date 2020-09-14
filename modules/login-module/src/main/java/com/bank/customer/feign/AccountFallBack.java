package com.bank.customer.feign;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bank.account.model.Account;
import com.bank.common.handlers.ResponseHandlers;
import com.bank.common.model.ServiceResponse;

import feign.hystrix.FallbackFactory;

@Component
public class AccountFallBack implements FallbackFactory<AccountFeignController>{
		
	@Override
	public AccountFeignController create(Throwable cause) {
		// TODO Auto-generated method stub
		return new AccountFeignController() {
			@Override
			public ResponseEntity<ServiceResponse<Optional<Account>>> findById(int id) {
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}

			@Override
			public ResponseEntity<ServiceResponse<Account>> CreateAccount(Account data) {
				// TODO Auto-generated method stub
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}

			/*@Override
			public ResponseEntity<ServiceResponse<Account>> findByAccountNo(String accountNo) {
				// TODO Auto-generated method stub
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}*/

			@Override
			public ResponseEntity<ServiceResponse<Account>> updateAccount(Account account, int id) {
				// TODO Auto-generated method stub
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}

			@Override
			public void deleteAccountById(int id) {
				// TODO Auto-generated method stub
				new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}
		};
	}
}
