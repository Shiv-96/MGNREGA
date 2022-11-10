package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mgnrega.exception.BDOException;
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
	
	
	
	
}
