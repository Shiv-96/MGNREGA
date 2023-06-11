package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.EmployeeDao;
import com.mgnrega.dao.EmployeeDaoImpl;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.Employee;

public class CreateNewEmployee {
	
	public static String createEmployee(int id, String gpmName) {
		
		String name = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee name : ");
		String employeename = sc.nextLine();
		
		System.out.println("Enter Employee Address : ");
		String employeeAddress = sc.nextLine();
		
		Employee employee = new Employee();
		
		employee.setEmployeeName(employeename);
		employee.setEmployeeAddress(employeeAddress);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			name = dao.createNewEmployee(employee, id, gpmName);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return name;
	}
	
}
