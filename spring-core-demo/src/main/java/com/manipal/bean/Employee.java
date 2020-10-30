package com.manipal.bean;

public class Employee {
	
	private String empName;
	private int empId;
	private int salary;
	
	public Employee() {}
	
	public Employee(String empName, int empId, int salary) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

}
