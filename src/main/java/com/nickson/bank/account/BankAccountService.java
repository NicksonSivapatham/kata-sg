package com.nickson.bank.account;

import java.time.LocalDateTime;

import com.nickson.bank.Amount;

public interface BankAccountService {
	
	void deposit(Long accountId, Amount amount);
	
	void withdraw(Long accountId, Amount amount);
	
	String viewHistory(Long accountId, LocalDateTime startDate, LocalDateTime endDate);
}
