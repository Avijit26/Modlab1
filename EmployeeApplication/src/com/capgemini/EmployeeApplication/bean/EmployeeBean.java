package com.capgemini.EmployeeApplication.bean;

public class EmployeeBean {
	
	private int employeeId;
	private String name;
	private int salary;
	private String department;
	private String designation;
	public EmployeeBean() {
		super();
	}
	public EmployeeBean(int employeeId, String name, int salary, String department,
			String designation) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.designation = designation;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", salary=" + salary + ", department=" + department
				+ ", designation=" + designation + "]";
	}

	
	
	
	
	
	
}
