package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;
import com.mgnrega.utility.DBUtill;

public class GPMDaoImpl implements GPMDao {

	@Override
	public String createGramPanchayatMember(GPM gpm) throws GPMException {
		String message = "Not Inserted";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into gpm (Member_Name, Memeber_Village, Username, Password) values (?, ?, ?, ?)");
			
			ps.setString(1, gpm.getGpmName());
			ps.setString(2, gpm.getGpmVillage());
			ps.setString(3, gpm.getGpmUser());
			ps.setString(4, gpm.getPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = gpm.getGpmName()+ " is added succesfully in Gram Panchayat Member list";
			}
			
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return message;
	}
	
	
	
	
}
