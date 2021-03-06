package com.nickson.bank.account;

import java.time.LocalDateTime;

import com.nickson.bank.Amount;
import com.nickson.bank.account.exception.InsufficientFundsException;

/**
 * Interface to represent the possible action on a bankAccount
 * @author nicks
 *
 */
public interface BankAccountService {
	
	/**
	 * Deposit an amount to an account
	 * @param accountId
	 * @param amount
	 */
	void deposit(Long accountId, Amount amount);
	
	/**
	 * Withdraw from an account
	 * @param accountId
	 * @param amount
	 * @throws InsufficientFundsException 
	 */
	void withdraw(Long accountId, Amount amount) throws InsufficientFundsException;
	
	/**
	 * Return the history of transaction in formatted String 
	 * @param accountId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	String viewHistory(Long accountId, LocalDateTime startDate, LocalDateTime endDate);
}
