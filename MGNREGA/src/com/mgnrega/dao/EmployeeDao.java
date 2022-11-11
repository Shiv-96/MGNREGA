package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.Employee;

public interface EmployeeDao {
	
	public String createNewEmployee(Employee employee, int id, String gpmmname);
	
	public List<Employee> getAllEmployee(int id) throws EmployeeException;
	
}
