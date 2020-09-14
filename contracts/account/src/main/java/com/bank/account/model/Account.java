package com.bank.account.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "acc_no")
	@NotNull
	@Pattern(regexp = "[0-9]{9,18}")
	private String accountNo;
	@NotNull
	@Pattern(regexp = "[A-Z]{4}[0-9]{7}")
	@Column(name = "ifsc_code")
	private String ifsc;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "micr_code")
	private long micrCode;
	private double amount;
	
	
	
	

}
