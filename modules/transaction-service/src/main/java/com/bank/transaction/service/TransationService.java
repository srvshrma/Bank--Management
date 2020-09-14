package com.bank.transaction.service;

import com.bank.account.model.Account;
import com.bank.model.Payment;

public interface TransationService {
	Payment checkPayment(Account account);
}
