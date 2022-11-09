package com.mgnrega.dao;

import com.mgnrega.exception.BDOException;
import com.project.model.BDO;

public interface BDODao {
	
	public BDO loginBDO(String username, String paassword) throws BDOException;
	
}
