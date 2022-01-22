package com.nickson.bank.transactions;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
	
	public List<Transaction> getTransactionsFromId(Long accountId);
	public Optional<Transaction> getLastTransaction(Long accountId);
}
