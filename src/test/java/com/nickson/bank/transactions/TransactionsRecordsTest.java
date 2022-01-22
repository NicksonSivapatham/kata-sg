package com.nickson.bank.transactions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;
import com.nickson.bank.account.exception.InsufficientFundsException;
import com.nickson.bank.account.exception.InvalidAmountException;

class TransactionsRecordsTest {

	@Test
	void testGetTransactionsFromId() throws InvalidAmountException, InsufficientFundsException {
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 01, 00, 00, 00);
		List<Transaction> expectedTransactions = List.of(
				new Transaction(1l, Transaction.Operation.DEPOSIT, now, new Amount(1000), new Balance(1000)),
				new Transaction(1l, Transaction.Operation.DEPOSIT, now.plusHours(1), new Amount(1000), new Balance(2000)),
				new Transaction(1l, Transaction.Operation.WITHDRAWAL, now.plusHours(2), new Amount(1000), new Balance(1000)));
		TransactionsRecords repository = new TransactionsRecords();
		
		List<Transaction> result = repository.getTransactionsFromId(1l);
		
		assertEquals(expectedTransactions, result);
	}

	@Test
	void testGetLastTransaction() throws InvalidAmountException, InsufficientFundsException {
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 01, 00, 00, 00);
		Transaction expectedTransactions = new Transaction(1l, Transaction.Operation.WITHDRAWAL, now.plusHours(2), new Amount(1000), new Balance(1000));
		TransactionsRecords repository = new TransactionsRecords();
		
		Optional<Transaction> result = repository.getLastTransaction(1l);
		
		assertEquals(expectedTransactions, result.get());
		
		result = repository.getLastTransaction(4l);
		
		assertTrue(result.isEmpty());
	}

}
