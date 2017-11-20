package com.capgemini.EmployeeApplication.exception;

public class EmployeeException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6579748842673397012L;
	public EmployeeException()
	{
		super();
	}
	public EmployeeException(String messege) {
		super(messege);
		
	}

}
