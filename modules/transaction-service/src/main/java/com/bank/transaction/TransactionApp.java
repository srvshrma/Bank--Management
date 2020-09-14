package com.bank.transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransactionApp 
{
	public static final Logger logger=LoggerFactory.getLogger(TransactionApp.class);
    public static void main( String[] args )
    {
        SpringApplication.run(TransactionApp.class, args);
    }

}
