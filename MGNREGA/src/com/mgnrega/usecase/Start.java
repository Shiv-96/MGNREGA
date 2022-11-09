package com.mgnrega.usecase;

import java.util.Scanner;

public class Start {
	
	public static void main(String[] args) {
		
		System.out.println("*******Welcome to MGNREGA******");
		System.out.println("===============================");
		Scanner sc = new Scanner(System.in);
		boolean x = true;
		
		while(x) {
			
			System.out.println("Press 1 for Block Development Officer Login");
			System.out.println("Press 2 for Gram Panchayat Member Login");
			System.out.println("Press 3 for exit");
			System.out.println("============================================");
			String choice = sc.next();
			
			if(choice.equals("3")) {
				System.out.println("Thank you for using our application");
				break;
			}
			else {
				System.out.println("Please enter correct option");
			}
			
		}
		
	}
	
}
