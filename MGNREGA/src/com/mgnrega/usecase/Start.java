package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.exception.GPMException;

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
				
				String name = LoginForBDO.loginAsABDO();
				
				if(name.equalsIgnoreCase("invalid credential")) {
					System.out.println(name);
					y = false;
				}
				else {
					System.out.println("Welcome "+name);
					y = true;
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
					}
					else if(bdoChoice.equals("1")) {
						CreateProject.createProjectUndeBDO(name);
					}
					else if(bdoChoice.equals("2")) {
						GetAllProject.getListPfProject();
					}
					else if(bdoChoice.equals("3")) {
						CreateGramPanchayatMember.createGramPanchayatMember();
					}
					else if(bdoChoice.equals("4")) {
						GetAllGramPanchayatMember.getTheGramPanchayatMemeber();
					}
					else if(bdoChoice.equals("5")) {
						AllocateProject.allocateProjectToGPM();
					}
					else if(bdoChoice.equals("6")) {
						System.out.println("You want to see the list of employee working on that project and their wages");
					}
					else {
						System.out.println("Please choose correct option");
					}
				}
				
			}
			else if(choice.equals("2")) {
				
				String name;
				try {
					name = LoginForGPM.loginAsAGPM();
					System.out.println("Welcome "+name);
					
					while(z) {
						
						System.out.println("Press 1 for Creating a new Employee");
						System.out.println("Press 2 for seeing the list of Employee Details");
						System.out.println("Press 3 for Assign a employee to a Project");
						System.out.println("Press 4 for seeing the total number of days Employee worked in a project and their wages");
						System.out.println("Press 5 for Exit.....!!!");
						
						String gpmChoice = sc.next();
						
						if(gpmChoice.equals("5")) {
							z = false;
							System.out.println("Thank you "+name);
							System.out.println("See you again...");
						}
						if(gpmChoice.equals("1")) {
							String xyz = CreateNewEmployee.createEmployee();
							
							System.out.println(xyz);
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
