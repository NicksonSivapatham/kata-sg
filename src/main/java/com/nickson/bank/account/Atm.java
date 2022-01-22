package com.nickson.bank.account;

import java.time.LocalDateTime;
import java.util.Optional;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;
import com.nickson.bank.account.exception.InsufficientFundsException;
import com.nickson.bank.transactions.Transaction;
import com.nickson.bank.transactions.TransactionRepository;

public class Atm implements BankAccountService{
	
	private TransactionRepository transactionRepository;
	
	public Atm(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}
	@Override
	public void deposit(Long accountId, Amount amount) {
		// Retrieve last transaction
		Optional<Transaction> lastTransaction = this.transactionRepository.getLastTransaction(accountId);
		Balance balance;
		
		// Get the last balance if exist else is 0
		if (lastTransaction.isPresent()) {
			balance = lastTransaction.get().getBalance();	
		} else {
			balance = new Balance();
		}
		
		// Add amount to balance and create a transaction
		balance.add(amount);	
		Transaction newTransaction = new Transaction(accountId, Transaction.Operation.DEPOSIT, LocalDateTime.now(), amount, balance);
		
		// Save
		this.transactionRepository.saveTransaction(newTransaction);
	}
	
	@Override
	public void withdraw(Long accountId, Amount amount) throws InsufficientFundsException {
		// Retrieve last transaction
		Optional<Transaction> lastTransaction = this.transactionRepository.getLastTransaction(accountId);
		Balance balance;
		
		// Get the last balance if exist else is 0
		if (lastTransaction.isPresent()) {
			balance = lastTransaction.get().getBalance();	
		} else {
			balance = new Balance();
		}
		
		// Remove amount to balance and create a transaction
		balance.substract(amount);	
		Transaction newTransaction = new Transaction(accountId, Transaction.Operation.WITHDRAW, LocalDateTime.now(), amount, balance);
		
		// Save
		this.transactionRepository.saveTransaction(newTransaction);
	}
	@Override
	public String viewHistory(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
