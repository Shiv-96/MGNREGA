package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.GPM;

public interface GPMDao {
	
	public String createGramPanchayatMember(GPM gpm) throws GPMException;
	
	public GPM loginasAGPM(String user, String pass) throws GPMException;
	
	public List<GPM> getAllGramPanchayatMemeber() throws GPMException;
	
	public String allocateEmployeeToProject(int empID, int projectID) throws EmployeeException, ProjectException;
	
}
