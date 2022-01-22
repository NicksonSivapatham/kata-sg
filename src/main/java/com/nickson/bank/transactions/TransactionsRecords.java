package com.nickson.bank.transactions;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;
import com.nickson.bank.account.exception.InsufficientFundsException;
import com.nickson.bank.account.exception.InvalidAmountException;

public class TransactionsRecords implements TransactionRepository{
	
	private List<Transaction> repository;
	
	public TransactionsRecords() {
		super();
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 01, 00, 00, 00);
		try {
			this.repository = new ArrayList<>(List.of(
					new Transaction(1l, Transaction.Operation.DEPOSIT, now, new Amount(1000), new Balance(1000)),
					new Transaction(1l, Transaction.Operation.DEPOSIT, now.plusHours(1), new Amount(1000), new Balance(2000)),
					new Transaction(1l, Transaction.Operation.WITHDRAW, now.plusHours(2), new Amount(1000), new Balance(1000)),
					new Transaction(2l, Transaction.Operation.DEPOSIT, now.plusHours(1), new Amount(1000), new Balance(2000)),
					new Transaction(3l, Transaction.Operation.WITHDRAW, now.plusHours(2), new Amount(1000), new Balance(200))
					));
		} catch (InvalidAmountException | InsufficientFundsException e) {
			this.repository = new ArrayList<>();
		}
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

	@Override
	public List<Transaction> getTransactionsFromIdBetween(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
		Predicate<Transaction> isAfter; 
		Predicate<Transaction> isBefore; 
		if (startDate==null) {
			isAfter = t -> true;
		} else {
			isAfter = t -> t.getDate().isAfter(startDate);
		}
		if (endDate==null) {
			isBefore = t -> true;
		} else {
			isBefore = t -> t.getDate().isBefore(endDate);
		}
		return this.repository.stream()
								.filter(transaction -> transaction.getAccountId() == accountId)
								.filter(isAfter)
								.filter(isBefore)
								.toList();
	}

}
