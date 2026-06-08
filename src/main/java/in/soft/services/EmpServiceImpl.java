package in.soft.services;

import java.util.List;

import in.soft.dao.EmpDao;
import in.soft.entity.Employee;
import in.soft.factory.DaoFactory;
import in.soft.factory.ServiceFactory;

public class EmpServiceImpl implements EmpService 
{

	EmpDao dao=DaoFactory.getEmpDao();
	

	@Override
	public String addEmployee(Employee e) 
	{
		String employee = dao.addEmployee(e);
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		List<Employee> allEmployees = dao.getAllEmployees();
		return allEmployees;
	}

	@Override
	public String deleteEmployee(int id) 
	{
		String deleteEmployee = dao.deleteEmployee(id);
		
		return deleteEmployee;
	}

	@Override
	public String updateEmployee(Employee e) 
	{
		String updateEmployee = dao.updateEmployee(e);
		return updateEmployee;
	}

	@Override
	public Employee searchEmployee(int id)
	{
		Employee searchEmployee = dao.searchEmployee(id);
		return searchEmployee;
	}

	
}
