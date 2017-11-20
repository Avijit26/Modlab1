package com.capgemini.EmployeeApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.EmployeeApplication.bean.EmployeeBean;
import com.capgemini.EmployeeApplication.exception.EmployeeException;
import com.capgemini.EmployeeApplication.util.DBConnection;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public boolean insertEmployee(EmployeeBean employeeBean)
			throws EmployeeException {
		
		int records=0;
		boolean isInserted= false;
		
		
		try(Connection connEmployee = DBConnection.getInstance().getConnection();	
				
				
		PreparedStatement preparedStatement=connEmployee.prepareStatement(QueryMapperEmployee.INSERT_EMPLOYEE);)
				{
					//java.sql.Date purchaseDate= new Date(new java.util.Date().getTime());
					//preparedStatement.setInt(1,purchaseDetailBean.getPurchaseId()); 
					preparedStatement.setString(1,employeeBean.getName());
					preparedStatement.setLong(2,employeeBean.getSalary());
					preparedStatement.setString(3,employeeBean.getDepartment());
					//preparedStatement.setDate(4,EmployeeDate);
					preparedStatement.setString(5,employeeBean.getDesignation());
					
					records=preparedStatement.executeUpdate();
					
					
					if(records>0){
						isInserted=true;
					}
				}catch(SQLException sqlEx){
					throw new EmployeeException(sqlEx.getMessage());
				}
		return isInserted;
	}

	@Override
	public boolean updateEmployee(int employeeId, int salary)
			throws EmployeeException {
		
		int records=0;
		boolean isUpdated= false;
		
		
		try(Connection connEmployee = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=connEmployee.prepareStatement(QueryMapperEmployee.UPDATE_EMPLOYEE);)
				{
					
					preparedStatement.setLong(1,salary);
					preparedStatement.setInt(2,employeeId);
					
					
					records=preparedStatement.executeUpdate();
					
					
					if(records>0){
						isUpdated=true;
					}
				}catch(SQLException sqlEx){
					throw new EmployeeException(sqlEx.getMessage());
				}
		return isUpdated;
		
	}

	@Override
	public List<EmployeeBean> viewAll() throws EmployeeException {
int records=0;
		
		List<EmployeeBean>employeeList= new ArrayList<EmployeeBean>();
		
		try(Connection connEmployee = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=connEmployee.prepareStatement(QueryMapperEmployee.VIEW_EMPLOYEE);
		
			ResultSet rsEmployee = preparedStatement.executeQuery();)
				{
			
			
			
			while(rsEmployee.next())
			{
				EmployeeBean employee = new EmployeeBean();
				
				employee.setEmployeeId(rsEmployee.getInt("mobileId"));
				employee.setName(rsEmployee.getString("name"));
				employee.setSalary(rsEmployee.getInt("price"));
				employee.setDepartment(rsEmployee.getString("department"));
				employee.setDesignation(rsEmployee.getString("designation"));
				employeeList.add(employee);
				
				if(employeeList.size()==0)
				{
					throw new EmployeeException("No Records Found");
				}
			}
			}catch(SQLException sqlEx){
					throw new EmployeeException(sqlEx.getMessage());
				}
		
		
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int employeeId) throws EmployeeException {
		int records=0;
		boolean isDeleted= false;
		
		
		try(Connection connEmployee = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=connEmployee.prepareStatement(QueryMapperEmployee.DELETE_EMPLOYEE);)
				{
					
				
					preparedStatement.setInt(1,employeeId);
					
					
					records=preparedStatement.executeUpdate();
					
					
					if(records>0){
						isDeleted=true;
					}
				}catch(SQLException sqlEx){
					throw new EmployeeException(sqlEx.getMessage());
				}
		return isDeleted;
		
	}

	@Override
	public List<EmployeeBean> search(int salary) throws EmployeeException {
		
int records=0;
		
		List<EmployeeBean>employeeList= new ArrayList<EmployeeBean>();
		
		try(Connection connEmployee = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=connEmployee.prepareStatement(QueryMapperEmployee.SEARCH_EMPLOYEE);)
				
				
				
				{
					preparedStatement.setLong(1, salary);
					
					ResultSet rsEmployee = preparedStatement.executeQuery();
			
			
			while(rsEmployee.next())
			{
				EmployeeBean employee = new EmployeeBean();
				
				
				employee.setEmployeeId(rsEmployee.getInt("employeeId"));
				employee.setName(rsEmployee.getString("name"));
				employee.setSalary(rsEmployee.getInt("salary"));
				employee.setDepartment(rsEmployee.getString("department"));
				employee.setDesignation(rsEmployee.getString("designation"));
				
				
				employeeList.add(employee);
			}
				
				if(employeeList.size()==0)
				{
					throw new EmployeeException("No Records Found");
				}
			
			}catch(SQLException sqlEx){
					throw new EmployeeException(sqlEx.getMessage());
				}
		
		
		return employeeList;
	}

}
