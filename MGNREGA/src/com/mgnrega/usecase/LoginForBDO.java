package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exception.BDOException;
import com.project.model.BDO;

public class LoginForBDO {
	
	public static BDO loginAsABDO() throws BDOException {
		BDO bdo = new BDO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User name");
		String user = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			bdo = dao.loginBDO(user, pass);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BDOException("Invalid Credential");
		}
		
		
		return bdo;
	}
	
}
