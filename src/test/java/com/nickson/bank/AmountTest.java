package com.nickson.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nickson.bank.account.exception.InvalidAmountException;

class AmountTest {

	@Test
	void testConstructorThrowsInvalidAmountException() {
		assertThrows(InvalidAmountException.class, () -> new Amount(-2));
	}

}
