package EmployeeManagement;

public class Employee {
	
	private int empId;
	private String empName;
	private String department;
	private double salary;

	public Employee() {
	}
	
	public Employee(int empId, String empName, String department,  double salary) {
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
	}
	
	public void setempId(int empId) {
		this.empId = empId;
	}
	
	public int getempId() {
		return empId;
	}
	
	public void setempName(String empName) {
		this.empName = empName;
	}
	
	public String getempName() {
		return empName;
	}
	
	public void setdepartment(String department) {
		this.department = department;
	}
	
	public String getdepartment() {
		return department;
	}
	
	public void setsalary(double salary) {
		this.salary = salary;
	}
	
	public double getsalary() {
		return salary;
	}
	
	public String toString() {
		return "Student [empId=" + empId + ", empName = " + empName + ", department = " + department + ", salary = " + salary + "]";
	}

}
