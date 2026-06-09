package EmployeeManagement;

import java.util.List;

public interface EmployeeDAO {
	
	void save(Employee e) throws Exception ; 
	public void delete(int empId) throws Exception;
	void update(Employee e) throws Exception;
	public void Search(int empId) throws Exception;
	List<Employee> displayAll() throws Exception;
}
