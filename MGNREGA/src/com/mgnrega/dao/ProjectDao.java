package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;

public interface ProjectDao {
	
	public String createProject(Project project, String name) throws ProjectException;
	
	public List<Project> getAllProject() throws ProjectException;
	
}
