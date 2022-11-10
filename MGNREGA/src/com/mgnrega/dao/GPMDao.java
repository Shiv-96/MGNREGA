package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;

public interface GPMDao {
	
	public String createGramPanchayatMember(GPM gpm) throws GPMException;
	
	public List<GPM> getAllGramPanchayatMemeber() throws GPMException;
	
}
