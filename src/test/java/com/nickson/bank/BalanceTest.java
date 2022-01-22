package com.nickson.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.nickson.bank.account.exception.InsufficientFundsException;
import com.nickson.bank.account.exception.InvalidAmountException;

class BalanceTest {

	@Test
	void testAdd() throws InvalidAmountException {
		Balance balance = new Balance();
		balance.add(new Amount(5));
		assertEquals(5, balance.getBalance().intValue());
	}

	@Test
	void testSubstract() throws InvalidAmountException, InsufficientFundsException {
		Balance balance = new Balance();
		balance.setMaximalOverdraft(new BigDecimal(-10));
		balance.substract(new Amount(5));
		assertEquals( -5, balance.getBalance().intValue());
	}
	
	@Test
	void testSubstractWhileInsufficientBalance() throws InvalidAmountException {
		Balance balance = new Balance();
		assertThrows( InsufficientFundsException.class, () -> balance.substract(new Amount(5)));
	}

}
