package com.edge.service.edgeservice.entity;

public class Employee {

	private long id;
	private String empName;
	private long deptId;
	private String department;
	private long salary;
	private String designation;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", deptId="
				+ deptId + ", department=" + department + ", salary=" + salary
				+ ", designation=" + designation + "]";
	}
	
}
