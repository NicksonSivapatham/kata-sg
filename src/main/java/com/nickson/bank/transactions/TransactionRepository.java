package com.nickson.bank.transactions;

import java.util.List;
import java.util.Optional;

/**
 * Interface to retrieve transaction from a repo
 * @author nicks
 *
 */
public interface TransactionRepository {
	
	/**
	 * Get all transactions from an account
	 * @param accountId 
	 * @return List<Transaction>
	 */
	public List<Transaction> getTransactionsFromId(Long accountId);
	
	/**
	 * Return an optional of the last transaction of an account
	 * Thus the optional will be empty in case of no activity from the selected account
	 * @param accountId
	 * @return Optional<Transaction>
	 */
	public Optional<Transaction> getLastTransaction(Long accountId);
}
