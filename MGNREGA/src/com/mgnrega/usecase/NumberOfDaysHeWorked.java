package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exception.GPMException;

public class NumberOfDaysHeWorked {

	public static void numberOfDaysWorked(int id) {
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			
			List<String> messages = dao.numberOfDaysWorked(id);
			
			messages.stream().forEach(message -> {
				
				System.out.println(message);
				
			});
			
			System.out.println("============================");
			
		} catch (GPMException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
