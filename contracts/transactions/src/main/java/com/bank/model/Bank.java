package com.bank.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Bank {
	private String name;
	private String host;
	private Integer port;
	
	public String getFullUrl() {
		return "http://" + this.getHost() + ":" + this.getPort() + "/" + this.getName().toLowerCase();
	}

}
