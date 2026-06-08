package in.soft.dao;

import java.util.List;

import in.soft.entity.Employee;

public interface EmpDao 
{
	String addEmployee(Employee e);
	List<Employee> getAllEmployees();
	String deleteEmployee(int id);
	String updateEmployee(Employee e);
	Employee searchEmployee(int id);
	
}
