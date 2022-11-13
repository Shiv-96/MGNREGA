package com.mgnrega.model;

public class EmployeeDTO {
	
	private String empName;
	private String projName;
	private int wages;
	private String gpmName;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(String empName, String projName, int wages, String gpmName) {
		super();
		this.empName = empName;
		this.projName = projName;
		this.wages = wages;
		this.gpmName = gpmName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	public String getGpmName() {
		return gpmName;
	}

	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empName=" + empName + ", projName=" + projName + ", wages=" + wages + ", gpmName="
				+ gpmName + "]";
	}
	
}
