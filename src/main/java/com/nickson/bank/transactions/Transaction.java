package com.nickson.bank.transactions;

import java.time.LocalDateTime;
import java.util.Objects;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;

public class Transaction {
	
	 public enum Operation {
	        DEPOSIT,
	        WITHDRAW
	 }
	 
	 private Long accountId;
	 private Operation type;
	 private LocalDateTime date;
	 private Amount amount;
	 private Balance balance;
	 
	public Transaction(Long accountId, Operation type, LocalDateTime date, Amount amount, Balance balance) {
		super();
		this.setAccountId(accountId);
		this.type = type;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountId, amount, balance, date, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(amount, other.amount)
				&& Objects.equals(balance, other.balance) && Objects.equals(date, other.date) && type == other.type;
	}

	public Operation getType() {
		return type;
	}
	public void setType(Operation type) {
		this.type = type;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public Balance getBalance() {
		return balance;
	}
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "accountId=" + accountId + "| type=" + type + "| date=" + date + "| amount=" + amount
				+ "| balance=" + balance;
	}
}
