package com.capgemini.EmployeeApplication.dao;

import java.util.List;

import com.capgemini.EmployeeApplication.bean.EmployeeBean;
import com.capgemini.EmployeeApplication.exception.EmployeeException;




public interface IEmployeeDAO {
	
	public boolean insertEmployee(final EmployeeBean employeeBean) throws EmployeeException;
	
    public boolean updateEmployee(final int employeeId,final int salary) throws EmployeeException;
	
	public List<EmployeeBean> viewAll() throws EmployeeException;
	
	public boolean deleteEmployee (final int employeeId) throws EmployeeException;
	
	public List<EmployeeBean> search(final int salary) throws EmployeeException;
	

}
