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

import com.bank.common.model.ServiceResponse;
import com.bank.fund.model.MutualFund;


@FeignClient(value="mutual-fund-service",url = "http://localhost:8082/",fallbackFactory =MutualFundFallBack.class)
public interface MutualFundControllerFeign {
	@LoadBalanced
	@RequestMapping(value = "/purchase/fund",method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse<MutualFund>> createFunds(@RequestBody MutualFund data);
	@LoadBalanced
	@RequestMapping(value = "/{id}/mutualfund",method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse<Optional<MutualFund>>> getById(@PathVariable(value="id") int id);
}
