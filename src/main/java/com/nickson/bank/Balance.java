package com.nickson.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import com.nickson.bank.account.exception.InsufficientFundsException;

public class Balance {
	
	BigDecimal balance;
	BigDecimal maximalOverdraft;
	
	public Balance() {
		this.balance = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
		this.maximalOverdraft = BigDecimal.ZERO;
	}
	
	public Balance(Integer balance) throws InsufficientFundsException {
		this.maximalOverdraft = BigDecimal.ZERO;
		if(new BigDecimal(balance).compareTo(maximalOverdraft) < 0) {
			throw new InsufficientFundsException("Your funds are insufficient");
		}
		this.balance = new BigDecimal(balance).setScale(2, RoundingMode.HALF_EVEN);
		
	}
	
	@Override
	public String toString() {
		return balance.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(balance, maximalOverdraft);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balance other = (Balance) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(maximalOverdraft, other.maximalOverdraft);
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

	/**
	 * Add to balance
	 * @param amount
	 */
	public void add(Amount amount) {
		this.balance = getBalance().add(amount.getValue());
	}
	
	/**
	 * Withdraw from balance
	 * @param amount
	 * @throws InsufficientFundsException
	 */
	public void substract(Amount amount) throws InsufficientFundsException {
		BigDecimal newBalance = getBalance().subtract(amount.getValue());
		if(newBalance.compareTo(maximalOverdraft) < 0) {
			throw new InsufficientFundsException("Your funds are insufficient");
		} else {
			this.balance = newBalance;
		}
			
	}
}
