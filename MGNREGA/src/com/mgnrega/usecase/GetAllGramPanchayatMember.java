package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;

public class GetAllGramPanchayatMember {

	public static void getTheGramPanchayatMemeber() {
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			List<GPM> gpms = dao.getAllGramPanchayatMemeber();
			
			gpms.forEach(gpm -> {
				
				System.out.println("Memeber ID : "+gpm.getGpmId());
				System.out.println("Member Name : "+gpm.getGpmName());
				System.out.println("Member Village : "+gpm.getGpmVillage());
				System.out.println("Member UserName : "+gpm.getGpmUser());
				System.out.println("Member Password : "+gpm.getPassword());
				System.out.println("=========================================");
				
			});
			
		} catch (GPMException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
