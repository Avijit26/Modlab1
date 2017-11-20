package com.capgemini.EmployeeApplication.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.EmployeeApplication.bean.EmployeeBean;
import com.capgemini.EmployeeApplication.dao.EmployeeDAOImpl;
import com.capgemini.EmployeeApplication.dao.IEmployeeDAO;
import com.capgemini.EmployeeApplication.exception.EmployeeException;


public class ServiceEmployeeImpl implements IServiceEmployee {

	@Override
	public boolean insertEmployee(EmployeeBean employeeBean)
			throws EmployeeException {
		int employeeQuantity=0;
		boolean isItInserted= false;
		//boolean isUpdated= false;
		
		
		IEmployeeDAO employeeDAO= new EmployeeDAOImpl();
		//IMobileDAO mobileDAO = new MobileDAOImpl();
		
		
		//employeeQuantity = employeeDAO.getQuantity(employeeBean.getEmployeeId());
		
		if(employeeQuantity>0)
		{
			
		
		isItInserted = employeeDAO.insertEmployee(employeeBean);
		
		//mobileQuantity--;
		//isUpdated =mobileDAO.updateMobile(purchaseDetailBean.getMobileId(),mobileQuantity);
		
		}
		return (isItInserted /*&& isUpdated*/);
		
		 
		
	}
	
	public boolean isValidEmployeeId(int employeeId) throws EmployeeException
	{
		boolean isValid=false;
		String employee=Integer.toString(employeeId);
		String pattern = "[\\d]{4}";
		
		Pattern ptn = Pattern.compile(pattern);
		Matcher matcher= ptn.matcher(employee);
		isValid = matcher.matches();
		
		
		if(!isValid)
		{
			throw new EmployeeException("Employee Id must have of 4 digits");
		}
		return isValid;
		
	}
	
	public boolean isValidCName(String cname) throws EmployeeException

{
	boolean isValid=false;
	String pattern ="[A-Z]{1}[A-Za-z]{1,19}";

	Pattern ptn = Pattern.compile(pattern);
	Matcher matcher= ptn.matcher(cname);
	isValid = matcher.matches();
	
	
	
	if(!isValid)
	{
		throw new EmployeeException("Invalid name");
	}
	return isValid;
}
	
	
	
	public boolean isValidSalary(int salary) throws EmployeeException
	{
		boolean isValid=false;
		String sal=Integer.toString(salary);
		String pattern = "[\\d]{4}";

		Pattern ptn = Pattern.compile(pattern);
		Matcher matcher= ptn.matcher(sal);
		isValid = matcher.matches();
		
		if(!isValid)
		{
			throw new EmployeeException("Invalid Salary");
		}
		return isValid;
		
	}
	
	

	
	/*public boolean isValidMail(String mail) throws MobilePurchaseException
	{
		boolean isValid=false;
		String pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
		
		Pattern ptn = Pattern.compile(pattern);
		Matcher matcher= ptn.matcher(mail);
		isValid = matcher.matches();
		
		
		if(!isValid)
		{
			throw new MobilePurchaseException("Invalid Mail Id");
		}
		return isValid;
		
	}*/
	
	private IEmployeeDAO employeeDAO;

	public ServiceEmployeeImpl()
	{
		employeeDAO =new EmployeeDAOImpl();
	}

	
	@Override
	public List<EmployeeBean> viewAll() throws EmployeeException {
		List<EmployeeBean> employeeList= employeeDAO.viewAll();
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int employeeId) throws EmployeeException {
		IEmployeeDAO employeeDAO= new EmployeeDAOImpl();
		boolean isEmployeeDeleted= employeeDAO.deleteEmployee(employeeId);
		
		boolean isDeleted = employeeDAO.deleteEmployee(employeeId);
		
		return (isDeleted && isEmployeeDeleted);
	}

	@Override
	public List<EmployeeBean> search(int salary) throws EmployeeException {
		List<EmployeeBean> employeeList = employeeDAO.search(salary);
		return employeeList;
		
		
	}

	

}
