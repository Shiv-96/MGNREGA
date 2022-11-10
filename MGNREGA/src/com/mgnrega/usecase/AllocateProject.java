package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;

public class AllocateProject {

	public static void allocateProjectToGPM() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project ID : ");
		int id = sc.nextInt();
		
		System.out.println("Enter GPMID : ");
		int gpmid = sc.nextInt();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			String message = dao.allocateProjectToGPM(id, gpmid);
			
			System.out.println(message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
