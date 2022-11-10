package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.dao.ProjectDao;
import com.mgnrega.dao.ProjectDaoImpl;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;

public class CreateProject {
	
	public static void createProjectUndeBDO(String name) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter project name : ");
		String pr_name = sc.nextLine();
		
		System.out.println("Enter project located District : ");
		String pr_dist = sc.nextLine();
		
		System.out.println("Enter project Located Village : ");
		String pr_village = sc.nextLine();
		
		Project project = new Project();
		project.setProjectDist(pr_dist);
		project.setProjectName(pr_name);
		project.setProjectVillage(pr_village);
		
		ProjectDao dao = new ProjectDaoImpl();
		
		try {
			String message = dao.createProject(project, name);
			
			System.out.println(message);
			
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
	
}
