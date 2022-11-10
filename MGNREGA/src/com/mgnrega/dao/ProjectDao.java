package com.mgnrega.dao;

import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;

public interface ProjectDao {
	
	public String createProject(Project project, String name) throws ProjectException;
	
}
