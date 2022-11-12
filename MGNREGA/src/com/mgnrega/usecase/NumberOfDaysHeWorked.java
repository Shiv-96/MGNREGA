package com.mgnrega.usecase;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exception.GPMException;

public class NumberOfDaysHeWorked {

	public static void numberOfDaysWorked(int id) {
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			
			String message = dao.numberOfDaysWorked(id);
			
			System.out.println(message);
			
		} catch (GPMException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
