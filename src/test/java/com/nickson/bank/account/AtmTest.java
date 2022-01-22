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
		Atm atm = new Atm();
		TransactionRepository repository = TransactionsRecords.getInstance();
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
		Atm atm = new Atm();
		TransactionRepository repository = TransactionsRecords.getInstance();
		Transaction expectedTransaction = new Transaction(2l, Transaction.Operation.WITHDRAWAL, now, new Amount(50), new Balance(1950));
		
		atm.deposit(2l, new Amount(50));
		
		assertEquals(2, repository.getTransactionsFromId(2l).size());
		assertEquals(expectedTransaction.getAccountId(), repository.getLastTransaction(2l).get().getAccountId());
		assertEquals(expectedTransaction.getType(), repository.getLastTransaction(2l).get().getType());
		assertEquals(expectedTransaction.getAmount(), repository.getLastTransaction(2l).get().getAmount());
		assertEquals(expectedTransaction.getBalance(), repository.getLastTransaction(2l).get().getBalance());
	}

	@Test
	void testViewHistory() {
		fail("Not yet implemented");
	}

}
