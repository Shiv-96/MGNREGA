package com.mgnrega.usecase;

import java.util.Scanner;


import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.model.GPM;
import com.project.model.BDO;

public class Start {
	
	public static void main(String[] args) {
		
		System.out.println("*******Welcome to MGNREGA******");
		System.out.println("===============================");
		Scanner sc = new Scanner(System.in);
		boolean x = true;
		boolean y = true;
		boolean z = true;
		
		while(x) {
			
			System.out.println("Press 1 for Block Development Officer Login");
			System.out.println("Press 2 for Gram Panchayat Member Login");
			System.out.println("Press 3 for exit");
			System.out.println("============================================");
			String choice = sc.next();
			
			if(choice.equals("3")) {
				System.out.println("Thank you for using our application");
				x = false;
			}
			else if(choice.equals("1")) {
				
				BDO bdo;
				try {
					bdo = LoginForBDO.loginAsABDO();
				
				
					String name = bdo.getName();
				
					if(name.equalsIgnoreCase("invalid credential")) {
						System.out.println(name);
						y = false;
						x = true;
						z = true;
					}
					else {
						System.out.println("Welcome "+name);
						y = true;
						x = true;
						z = true;
					}
					while(y) {
						System.out.println("Press 1 for Creating a new Project");
						System.out.println("Press 2 for seeing the list of project");
						System.out.println("Press 3 for Creating a new Gram Panchayat Member");
						System.out.println("Press 4 for Seeing the list of Gram Panchayat Member");
						System.out.println("Press 5 for Allocating a Project to Gram Panchayat Member");
						System.out.println("Press 6 for Seeing the list of Employee working on that project and their wages");
						System.out.println("Press 7 for Exit...");
						String bdoChoice = sc.next();
					
					
						if(bdoChoice.equals("7")) {
							y = false;
							x = true;
							z = true;
						}
						else if(bdoChoice.equals("1")) {
							CreateProject.createProjectUndeBDO(name);
							y = true;
							x = true;
							z = true;
						}
						else if(bdoChoice.equals("2")) {
							GetAllProject.getListPfProject();
							y = true;
							x = true;
							z = true;
						}
						else if(bdoChoice.equals("3")) {
							CreateGramPanchayatMember.createGramPanchayatMember();
							y = true;
							x = true;
							z = true;
						}
						else if(bdoChoice.equals("4")) {
							GetAllGramPanchayatMember.getTheGramPanchayatMemeber();
							y = true;
							x = true;
							z = true;
						}
						else if(bdoChoice.equals("5")) {
							AllocateProject.allocateProjectToGPM();
							y = true;
							x = true;
							z = true;
						}
						else if(bdoChoice.equals("6")) {
							System.out.println("You want to see the list of employee working on that project and their wages");
							y = true;
							x = true;
							z = true;
						}
						else {
							System.out.println("Please choose correct option");
						}
					}
				}catch (BDOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			else if(choice.equals("2")) {
				
				try {
					GPM gpm = LoginForGPM.loginAsAGPM();
					
					String gpmName = gpm.getGpmName();
					
					System.out.println("Welcome "+gpmName);
					
					while(z) {
						
						System.out.println("Press 1 for Creating a new Employee");
						System.out.println("Press 2 for seeing the list of Employee Details");
						System.out.println("Press 3 for Assign a employee to a Project");
						System.out.println("Press 4 for seeing the total number of days Employee worked in a project and their wages");
						System.out.println("Press 5 for Exit.....!!!");
						
						String gpmChoice = sc.next();
						
						if(gpmChoice.equals("5")) {
							z = false;
							x = true;
							y = true;
							System.out.println("Thank you "+gpmName);
							System.out.println("See you again...");
						}
						if(gpmChoice.equals("1")) {
							
							int gpmID = gpm.getGpmId();
							
							String employeeName = CreateNewEmployee.createEmployee(gpmID, gpmName);
							
							System.out.println(employeeName+ " is registered by "+gpmName);
							y = true;
							z = true;
							x = true;
						}
						else if(gpmChoice.equals("2")) {
							y = true;
							z = true;
							x = true;
							
							GetAllEmployee.getAllEmployee(gpm.getGpmId(), gpm.getGpmName());
							
						}
						else if(gpmChoice.equals("3")) {
							
							x = true;
							y = true;
							z = true;
							int gpmId = gpm.getGpmId();
							AllocateEmployeeToProject.allocateEmployee(gpmId);
							
						}
						else if(gpmChoice.equals("4")) {
							
							x = true; 
							y = true;
							z = true;
							
							NumberOfDaysHeWorked.numberOfDaysWorked();
							
						}
					}
					
					
				} catch (GPMException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			}
			else {
				System.out.println("Please enter correct option");
				
			}
			
		}
		
	}
	
}
