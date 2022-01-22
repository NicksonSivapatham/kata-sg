package com.nickson.bank.transactions;

import com.nickson.bank.account.BankAccount;

public interface TransactionRepository {
	
	public BankAccount getTransactionsFromId(Long accountId);
}
