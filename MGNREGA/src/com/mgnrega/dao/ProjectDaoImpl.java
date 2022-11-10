package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;
import com.mgnrega.utility.DBUtill;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public String createProject(Project project, String name) throws ProjectException {
		String message = "Not Created...!!";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into project (Project_Name, Project_Village, Project_District) value(?, ?, ?) ");
			
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getProjectDist());
			ps.setString(3, project.getProjectVillage());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = project.getProjectName()+ " is created under "+name;
			}
			else {
				throw new ProjectException("Invalid Details");
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
			new ProjectException(e.getMessage());
		}
		
		
		
		return message;
	}
	
	
	
	
}
