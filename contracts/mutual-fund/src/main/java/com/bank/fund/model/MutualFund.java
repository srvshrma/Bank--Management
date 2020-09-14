package com.bank.fund.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class MutualFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Min(value=10)
    @NotNull
    private String fundId;
    private String schemeName;
	@Column(name = "amount_invested")
	private double amountToInvest;
	@Column(name = "time_stamp")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate timeStamp;
	

}
