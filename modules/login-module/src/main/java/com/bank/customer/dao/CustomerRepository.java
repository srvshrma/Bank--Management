package com.bank.customer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bank.customer.model.Customer;
@Repository
@EnableTransactionManagement
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByUserPan(String userPan);
	
}
