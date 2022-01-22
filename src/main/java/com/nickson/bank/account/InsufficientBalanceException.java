package com.nickson.bank.account;

public class InsufficientBalanceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2656109934898150519L;

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
