package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.dao.EmployeeDao;
import com.mgnrega.dao.EmployeeDaoImpl;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.EmployeeDTO;

public class ListOfEmployeeWorkingProject {

	public static void listOfEmployee() {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			
			List<EmployeeDTO> employeeDetails = dao.listOfAllEmployee();
			
			employeeDetails.forEach(employee -> {
				
				System.out.println("Employee Name : "+employee.getEmpName());
				System.out.println("Project Name : "+employee.getProjName());
				System.out.println("Gram Panchayat Memeber : "+employee.getGpmName());
				System.out.println("Wages Per Day : "+employee.getWages());
				System.out.println("======================================");
				
			});
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

}
