package com.bank.customer.feign;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.common.handlers.ResponseHandlers;
import com.bank.common.model.ServiceResponse;
import com.bank.fund.model.MutualFund;

import feign.hystrix.FallbackFactory;
@Component
public class MutualFundFallBack implements FallbackFactory<MutualFundControllerFeign>{

	@Override
	public MutualFundControllerFeign create(Throwable cause) {
		// TODO Auto-generated method stub
		return new MutualFundControllerFeign(){
			@Override
			public ResponseEntity<ServiceResponse<MutualFund>> createFunds(@RequestBody MutualFund data) {
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}

			@Override
			public ResponseEntity<ServiceResponse<Optional<MutualFund>>> getById(int id) {
				// TODO Auto-generated method stub
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}
			
		};
	}

	
}
