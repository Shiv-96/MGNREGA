package com.mgnrega.dao;

import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;
import com.project.model.BDO;

public interface BDODao {
	
	public BDO loginBDO(String username, String paassword) throws BDOException;
	
	public String allocateProjectToGPM(int projectID, int GPMID) throws ProjectException, GPMException;
	
}
