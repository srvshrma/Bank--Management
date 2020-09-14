package com.bank.fund.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.fund.dao.MutualFundRepository;
import com.bank.fund.model.MutualFund;
@Service
public class MutualFundServiceImpl implements MutualFundService {
@Autowired
MutualFundRepository repo;

	@Override
	public MutualFund createFund(MutualFund mutualFund) {
		// TODO Auto-generated method stub
		return repo.save(mutualFund);
	}

	@Override
	public Optional<MutualFund> findById(int id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id);
	}

}
