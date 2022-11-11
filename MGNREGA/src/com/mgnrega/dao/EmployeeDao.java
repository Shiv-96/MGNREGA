package com.mgnrega.dao;

import com.mgnrega.model.Employee;

public interface EmployeeDao {
	
	public String createNewEmployee(Employee employee, int id, String gpmmname);
	
}
