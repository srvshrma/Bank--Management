package com.bank.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class BankException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus errorCode;
	private String errorMessage;
	
	public BankException() {
		// TODO Auto-generated constructor stub
	}

	public BankException(String errorMessage) {
		super();
		this.errorCode = HttpStatus.NOT_FOUND;
		this.errorMessage = errorMessage;
	}
	
	public BankException(HttpStatus errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
