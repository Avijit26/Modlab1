package com.capgemini.EmployeeApplication.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.EmployeeApplication.bean.EmployeeBean;
import com.capgemini.EmployeeApplication.exception.EmployeeException;
import com.capgemini.EmployeeApplication.service.IServiceEmployee;
import com.capgemini.EmployeeApplication.service.ServiceEmployeeImpl;

public class ServiceEmployeeImplTest {
	
	private EmployeeBean employeeBean;

	@Before
	public void setUp() throws Exception {
		
		
		
		
		employeeBean= new EmployeeBean(1234,"Avijit",25000,"HR","Analyst");
	}

	@After
	public void tearDown() throws Exception {
		
		employeeBean= null;
	}

	@Test
	public final void testInsertEmployee() {
		IServiceEmployee serviceEmployee= new ServiceEmployeeImpl();
		try {
			assertTrue(serviceEmployee.insertEmployee(employeeBean));
		
		} catch (EmployeeException e)
		{
			e.printStackTrace();
		}
	}
	

}
