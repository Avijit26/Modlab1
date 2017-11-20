package com.capgemini.EmployeeApplication.pi;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.EmployeeApplication.bean.EmployeeBean;
import com.capgemini.EmployeeApplication.exception.EmployeeException;
import com.capgemini.EmployeeApplication.service.ServiceEmployeeImpl;

public class EmployeeMain {
	
	private static final Integer Int = null;
	//private static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("resources/log4j.properties");
		
		boolean isInProcess= true;
		boolean isValid= false;
		
		byte choice=0;
		
		int employeeId=0;
		String cname= null;
		int salary= 0;
		String department=null;
		String designation=null;
		
		ServiceEmployeeImpl serviceEmployee = new ServiceEmployeeImpl();
		
		//ServicePurchaseImpl 
		EmployeeBean employeeBean = null;
		
		
		List<EmployeeBean> employeeList = null;
		
		
		
		
		Scanner scInput = new Scanner(System.in);
		
		while(isInProcess)
		{
			System.out.println("1. Insert Employee Details ");
			System.out.println("2. View All Employee ");
			System.out.println("3. Delete Employee Details ");
			System.out.println("4. Search Employee for salary range ");
			System.out.println("0. Exit ");
			
			choice = Byte.parseByte(scInput.nextLine());
			switch(choice){
			case 1:
				
				while(!isValid){
					try { 
					System.out.println("Enter customer name:");
					cname=scInput.nextLine();
					
					isValid = serviceEmployee.isValidCName(cname);
						//isValid = ServicePurchaseMobile.
					}
				catch(EmployeeException mpe){
					//logger.error("invalid name: " +cname);
					System.err.println("invalid name: " +cname);
					isValid = false;
				}
					
				
				
				
			}
				
				
								
				
			
		
				
				

				isValid= false;
				
				
				while(!isValid){
					try { 
					System.out.println("Enter Salary:");
					//salary=scInput.nextInt();
					salary=Integer.parseInt(scInput.nextLine());
					isValid = serviceEmployee.isValidSalary(salary);
						//isValid = ServicePurchaseMobile.
					}
				catch(EmployeeException mpe){
					//logger.error("invalid Salary: " +salary);
					System.err.println("invalid Salary: " +salary);
					isValid = true;
				}
				
				
				
			}
				
				isValid= false;
				
				
				while(!isValid){
					try { 
					System.out.println("Enter employee id:");
					employeeId=Integer.parseInt(scInput.nextLine());
					
					isValid = serviceEmployee.isValidEmployeeId(employeeId);
						//isValid = ServicePurchaseMobile.
					}
				catch(EmployeeException mpe){
					//logger.error("invalid Mobile Id: " +employeeId);
					System.err.println("invalid Mobile Id: " +employeeId);
					isValid = true;
				}
				
				
				
			}
				
				employeeBean = new EmployeeBean(employeeId,cname,salary,department,designation);
				try {
					serviceEmployee.insertEmployee(employeeBean);
					
				}catch (EmployeeException e){
					//logger.error(e.getMessage());
					System.out.println(e.getMessage());
				}
				break;
				
				
			case 2:
					try { 
							employeeList= serviceEmployee.viewAll();
							
							for (EmployeeBean employeeBean1 :employeeList)
							{
								System.out.println(employeeBean1);
							}
							
							System.out.println("=================================================");
						}catch (EmployeeException e){
							//logger.error(e.getMessage());
							System.out.println(e.getMessage());
						}
					break;
					
			case 3:
				
				isValid= false;
				
				
				while(!isValid){
					try { 
					System.out.println("Enter employee id:");
					employeeId=Integer.parseInt(scInput.nextLine());
					
					isValid = serviceEmployee.isValidEmployeeId(employeeId);
						//isValid = ServicePurchaseMobile.
					}
				catch(EmployeeException mpe){
					//logger.error("invalid Employee Id: " +employeeId);
					isValid = true;
				}
				}
				try {
					boolean isDeleted= serviceEmployee.deleteEmployee(employeeId);
					if(isDeleted){
						System.out.println("Employee Record Deleted Successfully");
					}
				}catch (EmployeeException e){
					//logger.error(e.getMessage());
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				
				int salary1 = 0;
				
				System.out.print("Enter salary");
				salary1= Integer.parseInt(scInput.nextLine());
				
				
				try {
					employeeList = serviceEmployee.search(salary);
					
					for(EmployeeBean employeeBean2 :employeeList)
					{
						System.out.println(employeeBean2);
					}
					System.out.println("=========================================");
					
				}catch (EmployeeException e)
				{
					//logger.error(e.getMessage());
					System.out.println(e.getMessage());
				}
				break;	
				
			case 0:
				isInProcess = false;
				break;
				default:
					System.out.println("Invalid input");
					//logger.error("invalid input:" +choice);
					break;
					
		
		}
		

	}
		scInput.close();
		

		

	}

}
