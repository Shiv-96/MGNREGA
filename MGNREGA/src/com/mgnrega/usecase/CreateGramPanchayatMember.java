package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;

public class CreateGramPanchayatMember {
	
	public static void createGramPanchayatMember() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Gram Panchayat Member Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Gram Panchayat Member's Village : ");
		String vill = sc.nextLine();
		
		System.out.println("Enter their username");
		String user = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		GPM gpm = new GPM();
		
		gpm.setGpmName(name);
		gpm.setGpmUser(user);
		gpm.setGpmVillage(vill);
		gpm.setPassword(password);
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			String message = dao.createGramPanchayatMember(gpm);
			
			System.out.println(message);
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
