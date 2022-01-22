package com.nickson.bank.transactions;

import java.time.LocalDateTime;

import com.nickson.bank.Amount;
import com.nickson.bank.Balance;

public class Transaction {
	
	 public enum Operation {
	        DEPOSIT,
	        WITHDRAWAL
	 }
	 
	 private Operation type;
	 private LocalDateTime date;
	 private Amount amount;
	 private Balance balance;
	 
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
}
