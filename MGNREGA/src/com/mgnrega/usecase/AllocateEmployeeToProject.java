package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;

public class AllocateEmployeeToProject {

	public static void allocateEmployee(int memberID) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID : ");
		int empID = sc.nextInt();
		
		System.out.println("Enter Project ID : ");
		int projectID = sc.nextInt();
		
		System.out.println("Number of days he can work : ");
		int days = sc.nextInt();
		
		System.out.println("Enter wages per day : ");
		int wages = sc.nextInt();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			
			String result = dao.allocateEmployeeToProject(empID, projectID, days, wages, memberID);
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
