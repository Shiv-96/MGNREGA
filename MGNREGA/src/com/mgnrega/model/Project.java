package com.mgnrega.model;

public class Project {
	
	private int projectId;
	private String projectName;
	private String projectDist;
	private String projectVillage;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName, String projectDist, String projectVillage) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDist = projectDist;
		this.projectVillage = projectVillage;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDist() {
		return projectDist;
	}

	public void setProjectDist(String projectDist) {
		this.projectDist = projectDist;
	}

	public String getProjectVillage() {
		return projectVillage;
	}

	public void setProjectVillage(String projectVillage) {
		this.projectVillage = projectVillage;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDist=" + projectDist
				+ ", projectVillage=" + projectVillage + "]";
	}
	
	
	
}
