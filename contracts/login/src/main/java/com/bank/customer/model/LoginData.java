package com.bank.customer.model;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.bank.account.model.Account;
import com.bank.fund.model.MutualFund;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginData {
	
	private String custId;
	private String firstName;
	private String lastName;
	private String userPan;
	private String email;
	private String phoneNo;
	private LocalDate dob;
//	private Optional<Account> account;
//	private Optional<MutualFund> fund;
}
