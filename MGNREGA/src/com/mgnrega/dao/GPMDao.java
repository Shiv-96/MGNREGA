package com.mgnrega.dao;

import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;

public interface GPMDao {
	
	public String createGramPanchayatMember(GPM gpm) throws GPMException;
	
}
