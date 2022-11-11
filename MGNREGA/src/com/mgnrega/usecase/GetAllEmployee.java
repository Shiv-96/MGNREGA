package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.dao.EmployeeDao;
import com.mgnrega.dao.EmployeeDaoImpl;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.Employee;

public class GetAllEmployee {

	public static void getAllEmployee(int id, String name) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			
			List<Employee> employees = dao.getAllEmployee(id);
			
			employees.forEach(employee -> {
				
				System.out.println("Employee ID : "+employee.getEmployeeID());
				System.out.println("Employee Name : "+employee.getEmployeeName());
				System.out.println("Employee Address : "+employee.getEmployeeAddress());
				
			});
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage()+name);
		}
		
	}

}
