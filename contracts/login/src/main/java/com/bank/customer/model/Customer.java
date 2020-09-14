package com.bank.customer.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.bank.account.model.Account;
import com.bank.fund.model.MutualFund;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIgnoreProperties
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Min(value = 10)
	@NotNull
	private String custId;
	
	@NotNull
	@Column(name = "f_name")
	private String firstName;

	@NotNull
	@Column(name = "l_name")
	private String lastName;
	@Column(name = "user_pan")
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	@NotNull
	private String userPan;
	@NotNull
	//@Min(value = 8)
	//@Max(value = 16)
	private String password;
	@Email(message = "Email should be valid")
	private String email;
	@Min(value = 10)
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "d_o_b")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dob;
	
	
}
