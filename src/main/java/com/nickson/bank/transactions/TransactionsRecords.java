package com.nickson.bank.transactions;

import java.util.List;

public class TransactionsRecords implements TransactionRepository{
	
	List<Transaction> repository;

	@Override
	public List<Transaction> getTransactionsFromId(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getLastTransaction(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
