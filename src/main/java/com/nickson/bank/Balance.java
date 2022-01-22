package com.nickson.bank;

import java.math.BigDecimal;

import com.nickson.bank.account.InsufficientFundsException;

public class Balance {
	
	BigDecimal balance;
	BigDecimal maximalOverdraft;
	
	public Balance() {
		this.balance = BigDecimal.ZERO;
		this.maximalOverdraft = BigDecimal.ZERO;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	
	public BigDecimal getMaximalOverdraft() {
		return maximalOverdraft;
	}

	public void setMaximalOverdraft(BigDecimal maximalOverdraft) {
		this.maximalOverdraft = maximalOverdraft;
	}

	public void add(Amount amount) {
		this.balance = getBalance().add(amount.getValue());
	}
	
	public void substract(Amount amount) throws InsufficientFundsException {
		BigDecimal newBalance = getBalance().subtract(amount.getValue());
		if(newBalance.compareTo(maximalOverdraft) < 0) {
			throw new InsufficientFundsException("Your funds are insufficient");
		} else {
			this.balance = newBalance;
		}
			
	}
}
