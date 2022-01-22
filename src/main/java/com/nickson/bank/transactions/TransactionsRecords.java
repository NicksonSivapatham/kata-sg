package com.nickson.bank.transactions;

import java.util.List;

import com.nickson.bank.account.BankAccount;

public class TransactionsRecords implements TransactionRepository{
	
	List<Transaction> repository;

	@Override
	public BankAccount getTransactionsFromId(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
