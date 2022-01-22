package com.nickson.bank.account.exception;

public class InvalidAmountException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3053732667370109987L;

	public InvalidAmountException(String message) {
		super(message);
	}
}
