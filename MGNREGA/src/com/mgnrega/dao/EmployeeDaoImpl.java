package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.EmployeeDTO;
import com.mgnrega.utility.DBUtill;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String createNewEmployee(Employee employee, int id, String gpmName) {
		
		String name = "Not Created";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into employee (Employee_Name, Employee_Address, GPM_ID, GPM_Name) values (?, ?, ?, ?) where  ");
			
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmployeeAddress());
			ps.setInt(3, id);
			ps.setString(4, gpmName);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				name = employee.getEmployeeName();
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
		return name;
	}

	@Override
	public List<Employee> getAllEmployee(int id) throws EmployeeException {
		
		List<Employee> employees = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where GPM_ID = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int empid = rs.getInt("Employee_ID");
				String empname = rs.getString("Employee_Name");
				String empaddress = rs.getString("Employee_Address");
				
				Employee employee = new Employee(empid, empname, empaddress);
				
				employees.add(employee);
				
			}
			
			if(employees.size() == 0) {
				throw new EmployeeException("No Employee exist for ");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employees;
		
	}

	@Override
	public List<EmployeeDTO> listOfAllEmployee() throws EmployeeException {
		
		List<EmployeeDTO> employeeDetails = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select employee_project.employee_Name, gpm.Member_Name, employee_project.Project_Name, employee_project.Wages_Per_Days from employee_project inner join gpm on gpm.Member_ID=employee_project.Member_ID");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String empName = rs.getString("employee_Name");
				String gpmName = rs.getString("Member_Name");
				String projName = rs.getString("Project_Name");
				int wages = rs.getInt("Wages_Per_Days");
				
				EmployeeDTO employeeDTO = new EmployeeDTO(empName, projName, wages, gpmName);
				
				employeeDetails.add(employeeDTO);
				
			}
			
		} catch (SQLException e) {
			
			throw new EmployeeException(e.getMessage());
			
		}
		
		return employeeDetails;
		
	}

}
