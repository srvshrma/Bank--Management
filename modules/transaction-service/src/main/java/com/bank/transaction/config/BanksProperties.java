package com.bank.transaction.config;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.bank.model.Bank;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("active")
public class BanksProperties {
	private List<Bank> banks = new ArrayList<>();
	
	public static Bank bank;
	
	public List<String> getActiveBanks(){
		return banks.stream()
					.map(bank -> bank.getName())
					.collect(Collectors.toList());
	}
	
	public Map<String, Bank> getBanksMappings(){
		return banks.stream()
				.map(bank-> bank)
				.collect(Collectors.toMap(Bank::getName, Function.identity()));
	}

}
