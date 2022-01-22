package com.nickson.bank.account;

import java.time.LocalDateTime;

import com.nickson.bank.Amount;
import com.nickson.bank.transactions.TransactionRepository;
import com.nickson.bank.transactions.TransactionsRecords;

public class Atm implements BankAccountService{
	
	private TransactionRepository transactionRepository;
	
	public Atm() {
		super();
		this.transactionRepository = new TransactionsRecords();
	}
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
