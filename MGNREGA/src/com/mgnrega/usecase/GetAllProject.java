package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.dao.ProjectDao;
import com.mgnrega.dao.ProjectDaoImpl;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;

public class GetAllProject {
	
	public static void getListPfProject() {
		
		ProjectDao dao = new ProjectDaoImpl();
		
		try {
			List<Project> projects = dao.getAllProject();
			
			projects.forEach(project -> {
				
				System.out.println("Project ID : "+project.getProjectId());
				System.out.println("Project Name : "+project.getProjectName());
				System.out.println("Project Village : "+project.getProjectVillage());
				System.out.println("Project District : "+project.getProjectDist());
				System.out.println("===============================================");
				
			});
			
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
}
