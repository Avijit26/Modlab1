package com.capgemini.EmployeeApplication.dao;

public interface QueryMapperEmployee {

	
	public static final String INSERT_EMPLOYEE = "INSERT INTO Employee VALUES(employeeId_seq.NEXTVAL,?,?,?,?,?)";
	
	public static final String UPDATE_EMPLOYEE = "UPDATE Employee SET salary=? WHERE employeeId=?";
	
	public static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE employeeId=?";
	
	public static final String VIEW_EMPLOYEE = "SELECT employeeId,name,salary,department, designation FROM Employee";
	
	public static final String SEARCH_EMPLOYEE = "SELECT employeeId,name,salary,department, designation"
			+ " FROM Employee WHERE salary BETWEEN ? AND ?";

	

}
