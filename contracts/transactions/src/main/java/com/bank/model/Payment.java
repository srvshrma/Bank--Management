package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	private Success success;
	private Failure failure;
	private String bankName;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Success {
		private Integer successCode;
		private String message;
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Failure {
		private Integer failureCode;
		private String message;
	}

}
