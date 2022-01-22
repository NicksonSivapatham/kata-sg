package com.nickson.bank.transactions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Interface to retrieve transaction from a repo
 * @author nicks
 *
 */
public interface TransactionRepository {
	
	/**
	 * Get all transactions from an account between 2 dates
	 * Manage null case for date in order to comply with the default implementation of getTransactionsFromId
	 * @param accountId 
	 * @return List<Transaction>
	 */
	public List<Transaction> getTransactionsFromIdBetween(Long accountId, LocalDateTime startDate, LocalDateTime endDate);
	
	/**
	 * Get all transactions from an account
	 * @param accountId 
	 * @return List<Transaction>
	 */
	default public List<Transaction> getTransactionsFromId(Long accountId){
		return getTransactionsFromIdBetween(accountId, null, null);
	};
	
	/**
	 * Return an optional of the last transaction of an account
	 * Thus the optional will be empty in case of no activity from the selected account
	 * @param accountId
	 * @return Optional<Transaction>
	 */
	public Optional<Transaction> getLastTransaction(Long accountId);
	
	/**
	 * Save a new transaction to the repository
	 * @param transaction
	 * @return
	 */
	public Boolean saveTransaction(Transaction transaction);
}
