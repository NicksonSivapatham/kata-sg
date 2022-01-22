package com.nickson.bank.transactions;

import java.util.List;

public interface TransactionRepository {
	
	public List<Transaction> getTransactionsFromId(Long accountId);
	public Transaction getLastTransaction(Long accountId);
}
