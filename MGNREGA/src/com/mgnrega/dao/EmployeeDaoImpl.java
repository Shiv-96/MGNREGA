package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mgnrega.model.Employee;
import com.mgnrega.utility.DBUtill;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String createNewEmployee(Employee employee) {
		
		String name = "Not Created";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into employee (Employee_Name, Employee_Address) values (?, ?) ");
			
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmployeeAddress());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				name = employee.getEmployeeName();
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
		return name;
	}

}
