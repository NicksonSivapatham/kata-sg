package com.nickson.bank.transactions;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;
import com.nickson.bank.account.exception.InsufficientFundsException;
import com.nickson.bank.account.exception.InvalidAmountException;

public class TransactionsRecords implements TransactionRepository{
	
	private List<Transaction> repository;
	
	public TransactionsRecords() throws InvalidAmountException, InsufficientFundsException {
		super();
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 01, 00, 00, 00);
		this.repository = new ArrayList<>(List.of(
				new Transaction(1l, Transaction.Operation.DEPOSIT, now, new Amount(1000), new Balance(1000)),
				new Transaction(1l, Transaction.Operation.DEPOSIT, now.plusHours(1), new Amount(1000), new Balance(2000)),
				new Transaction(1l, Transaction.Operation.WITHDRAWAL, now.plusHours(2), new Amount(1000), new Balance(1000)),
				new Transaction(2l, Transaction.Operation.DEPOSIT, now.plusHours(1), new Amount(1000), new Balance(2000)),
				new Transaction(3l, Transaction.Operation.WITHDRAWAL, now.plusHours(2), new Amount(1000), new Balance(200))
				));
	}

	@Override
	public List<Transaction> getTransactionsFromId(Long accountId) {
		return this.repository.stream()
								.filter(transaction -> transaction.getAccountId() == accountId)
								.toList();
	}

	@Override
	public Optional<Transaction> getLastTransaction(Long accountId) {
		return this.repository.stream()
				.filter(transaction -> transaction.getAccountId() == accountId)
				.max(Comparator.comparing(Transaction::getDate));
	}

	@Override
	public Boolean saveTransaction(Transaction transaction) {
		return this.repository.add(transaction);
	}

}
