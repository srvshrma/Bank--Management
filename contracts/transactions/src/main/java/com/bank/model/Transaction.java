package com.bank.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	@Id
	@NotNull
	@Pattern(regexp = "[1-9]{1}[0-9]{12}")
	private String transactionId;
	private String accountNo;
	private String toAccount;
	private Status statusOfTransaction;
	private double amount;
	private String transactionDetails;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@NotNull
	private Date dateOfTransaction;
	
	private Payment payment;
	private String mutualFund;

}
