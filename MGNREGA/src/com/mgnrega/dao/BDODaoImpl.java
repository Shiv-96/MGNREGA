package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.utility.DBUtill;
import com.project.model.BDO;

public class BDODaoImpl implements BDODao {

	@Override
	public BDO loginBDO(String username, String paassword) throws BDOException {
		
		BDO bdo = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from bdo where username = ? AND password = ?");
			
			ps.setString(2, paassword);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String user = rs.getString("username");
				String pass = rs.getString("password");
				String name = rs.getString("name");
				
				bdo = new BDO(user, pass, name);
			}
			else {
				throw new BDOException("Invalid Credential");
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
			
		}
		
		return bdo;
	
	}

	@Override
	public String allocateProjectToGPM(int projectID, int GPMID) throws ProjectException, GPMException {
		
		String message = "Not Allocated....!!";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select * from project where project_Id = ?");
			
			ps1.setInt(1, projectID);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				
				String project_Name = rs1.getString("Project_Name");
				
				PreparedStatement ps2 = conn.prepareStatement("select * from GPM where Member_ID = ?");
				
				ps2.setInt(1, GPMID);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					String member_name = rs2.getString("Member_Name");
					
					PreparedStatement ps3 = conn.prepareStatement("insert into gpm_project values (?, ?)");
					
					ps3.setInt(2, GPMID);
					ps3.setInt(1, projectID);
					
					int x = ps3.executeUpdate();
					if(x > 0) {
						message = project_Name+" is assigned to "+member_name;
					}
					
				}
				else {
					throw new GPMException("Member doesn't exists with ID : "+GPMID);
				}
				
			}
			else {
				throw new ProjectException("Invalid Project ID : "+projectID);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new ProjectException(e.getMessage());
		}
		
		
		return message;
	}
	
	
	
	
}
