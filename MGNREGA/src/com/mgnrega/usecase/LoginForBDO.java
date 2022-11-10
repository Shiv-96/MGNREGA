package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exception.BDOException;
import com.project.model.BDO;

public class LoginForBDO {
	
	public static String loginAsABDO() {
		String message = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User name");
		String user = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			BDO bdo = dao.loginBDO(user, pass);
			
			message = bdo.getName();
			
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		
		return message;
	}
	
}
