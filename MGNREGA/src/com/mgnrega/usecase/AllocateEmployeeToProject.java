package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;

public class AllocateEmployeeToProject {

	public static void allocateEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID : ");
		int empID = sc.nextInt();
		
		System.out.println("Enter Project ID : ");
		int projectID = sc.nextInt();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			
			String result = dao.allocateEmployeeToProject(empID, projectID);
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
