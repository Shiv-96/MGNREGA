package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.EmployeeDTO;

public interface EmployeeDao {
	
	public String createNewEmployee(Employee employee, int id, String gpmmname) throws EmployeeException;
	
	public List<Employee> getAllEmployee(int id) throws EmployeeException;
	
	public List<EmployeeDTO> listOfAllEmployee() throws EmployeeException;
	
}
