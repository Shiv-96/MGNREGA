package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;
import com.mgnrega.utility.DBUtill;
import com.mysql.cj.protocol.Resultset;

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

	@Override
	public List<GPM> getAllGramPanchayatMemeber() throws GPMException {
		
		List<GPM> gpms = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from gpm");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("Member_ID");
				String name = rs.getString("Member_Name");
				String vill = rs.getString("Memeber_Village");
				String user = rs.getString("Username");
				String pass = rs.getString("Password");
				
				GPM gpm = new GPM(id, name, vill, user, pass);
				
				gpms.add(gpm);
				
			}
			
			if(gpms.size() == 0) {
				throw new GPMException("You don't have any Gram Panchayat Member");
			}
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		return gpms;
		
	}
	
	
	
	
}
