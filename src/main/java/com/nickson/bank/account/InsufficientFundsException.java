package com.nickson.bank.account;

public class InsufficientFundsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2656109934898150519L;

	public InsufficientFundsException(String message) {
		super(message);
	}
}
