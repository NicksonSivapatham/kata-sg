package com.nickson.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amount other = (Amount) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
