package com.bank.fund.service;

import java.util.Optional;

import com.bank.fund.model.MutualFund;

public interface MutualFundService {
	
	MutualFund createFund(MutualFund mutualFund);
	Optional<MutualFund> findById(int id);

}
