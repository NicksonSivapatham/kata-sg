package com.nickson.bank.account;

import java.time.LocalDateTime;
import java.util.List;

import com.nickson.bank.Amount;
import com.nickson.bank.transactions.TransactionRepository;

public class Atm implements BankAccountService{
	
	private TransactionRepository transactionRepository;
	
	@Override
	public void deposit(Long accountId, Amount amount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void withdraw(Long accountId, Amount amount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String viewHistory(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
