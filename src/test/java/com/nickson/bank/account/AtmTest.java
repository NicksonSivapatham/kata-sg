package com.nickson.bank.account;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;
import com.nickson.bank.account.exception.InsufficientFundsException;
import com.nickson.bank.account.exception.InvalidAmountException;
import com.nickson.bank.transactions.Transaction;
import com.nickson.bank.transactions.TransactionRepository;
import com.nickson.bank.transactions.TransactionsRecords;

class AtmTest {

	@Test
	void testDeposit() throws InvalidAmountException, InsufficientFundsException {
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 02, 00, 00, 00);
		TransactionRepository repository = new TransactionsRecords();
		Atm atm = new Atm(repository);
		Transaction expectedTransaction = new Transaction(2l, Transaction.Operation.DEPOSIT, now, new Amount(50), new Balance(2050));
		
		atm.deposit(2l, new Amount(50));
		
		assertEquals(2, repository.getTransactionsFromId(2l).size());
		assertEquals(expectedTransaction.getAccountId(), repository.getLastTransaction(2l).get().getAccountId());
		assertEquals(expectedTransaction.getType(), repository.getLastTransaction(2l).get().getType());
		assertEquals(expectedTransaction.getAmount(), repository.getLastTransaction(2l).get().getAmount());
		assertEquals(expectedTransaction.getBalance(), repository.getLastTransaction(2l).get().getBalance());
	}

	@Test
	void testWithdraw() throws InvalidAmountException, InsufficientFundsException {
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 02, 00, 00, 00);
		TransactionRepository repository = new TransactionsRecords();
		Atm atm = new Atm(repository);
		Transaction expectedTransaction = new Transaction(2l, Transaction.Operation.WITHDRAW, now, new Amount(50), new Balance(1950));
		
		atm.withdraw(2l, new Amount(50));
		
		assertEquals(2, repository.getTransactionsFromId(2l).size());
		assertEquals(expectedTransaction.getAccountId(), repository.getLastTransaction(2l).get().getAccountId());
		assertEquals(expectedTransaction.getType(), repository.getLastTransaction(2l).get().getType());
		assertEquals(expectedTransaction.getAmount(), repository.getLastTransaction(2l).get().getAmount());
		assertEquals(expectedTransaction.getBalance(), repository.getLastTransaction(2l).get().getBalance());
	}

	@Test
	void testViewHistory() {
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 01, 00, 00, 00);
		String expectedString = "accountId=1| type=DEPOSIT| date=2022-01-01T00:00| amount=1000.00| balance=1000.00\n" +
								"accountId=1| type=DEPOSIT| date=2022-01-01T01:00| amount=1000.00| balance=2000.00\n" +	
								"accountId=1| type=WITHDRAW| date=2022-01-01T02:00| amount=1000.00| balance=1000.00";
		TransactionRepository repository = new TransactionsRecords();
		Atm atm = new Atm(repository);
		
		String result = atm.viewHistory(1l, null, null);
		
		assertEquals(expectedString, result);
	}
	
	@Test
	void testViewHistoryBetweenDate() {
		LocalDateTime now = LocalDateTime.of(2022, Month.JANUARY, 01, 00, 00, 00);
		String expectedString = "accountId=1| type=DEPOSIT| date=2022-01-01T01:00| amount=1000.00| balance=2000.00";
		TransactionRepository repository = new TransactionsRecords();
		Atm atm = new Atm(repository);
		
		String result = atm.viewHistory(1l, now.plusMinutes(30), now.plusHours(2));
		
		assertEquals(expectedString, result);
	}


}
