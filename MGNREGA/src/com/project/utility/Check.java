package com.project.utility;

import java.sql.Connection;

public class Check {
	
	public static void main(String[] args) {
		
		Connection conn = DBUtill.provideConnection();
		
		System.out.println(conn);
		
	}
	
}
