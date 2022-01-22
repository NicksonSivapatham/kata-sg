package com.nickson.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.nickson.bank.account.exception.InvalidAmountException;

public class Amount {
	
	private final BigDecimal value;
	
	public Amount(int value) throws InvalidAmountException {
		if (value < 0) {
			throw new InvalidAmountException("The amount is negative");
		}
		this.value = new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getValue() {
		return value;
	}
	
}
