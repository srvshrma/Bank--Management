package com.bank.fund.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bank.fund.model.MutualFund;
@Repository
@EnableTransactionManagement
public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {

}
