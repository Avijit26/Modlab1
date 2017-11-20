package com.capgemini.EmployeeApplication.service;

import java.util.List;

import com.capgemini.EmployeeApplication.bean.EmployeeBean;
import com.capgemini.EmployeeApplication.exception.EmployeeException;

public interface IServiceEmployee {
	
public boolean insertEmployee(final EmployeeBean employeeBean) throws EmployeeException;
	
   
	
	public List<EmployeeBean> viewAll() throws EmployeeException;
	
	public boolean deleteEmployee (final int employeeId) throws EmployeeException;
	
	public List<EmployeeBean> search(final int salary) throws EmployeeException;

	

}
