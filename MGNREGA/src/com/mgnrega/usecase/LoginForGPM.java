package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;

public class LoginForGPM {
	
	public static GPM loginAsAGPM() throws GPMException {
		
		GPM gpm = new GPM();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username : ");
		String username = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			
			gpm = dao.loginasAGPM(username, password);
			
			
		} catch (Exception e) {
			
			throw new GPMException("Invalid Credential");
		}
		
		return gpm;
	}
	
}
