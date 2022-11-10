package com.mgnrega.model;

public class GPM {
	
	private int gpmId;
	private String gpmName;
	private String gpmVillage;
	private String gpmUser;
	private String password;
	
	public GPM() {
		
	}

	public GPM(int gpmId, String gpmName, String gpmVillage, String gpmUser, String password) {
		super();
		this.gpmId = gpmId;
		this.gpmName = gpmName;
		this.gpmVillage = gpmVillage;
		this.gpmUser = gpmUser;
		this.password = password;
	}

	public int getGpmId() {
		return gpmId;
	}

	public void setGpmId(int gpmId) {
		this.gpmId = gpmId;
	}

	public String getGpmName() {
		return gpmName;
	}

	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}

	public String getGpmVillage() {
		return gpmVillage;
	}

	public void setGpmVillage(String gpmVillage) {
		this.gpmVillage = gpmVillage;
	}

	public String getGpmUser() {
		return gpmUser;
	}

	public void setGpmUser(String gpmUser) {
		this.gpmUser = gpmUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GPM [gpmId=" + gpmId + ", gpmName=" + gpmName + ", gpmVillage=" + gpmVillage + ", gpmUser=" + gpmUser
				+ ", password=" + password + "]";
	}
	
}
