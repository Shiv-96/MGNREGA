package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.GPM;
import com.mgnrega.utility.DBUtill;
import com.mysql.cj.protocol.Resultset;

public class GPMDaoImpl implements GPMDao {

	@Override
	public String createGramPanchayatMember(GPM gpm) throws GPMException {
		String message = "Not Inserted";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into gpm (Member_Name, Memeber_Village, Username, Password) values (?, ?, ?, ?)");
			
			ps.setString(1, gpm.getGpmName());
			ps.setString(2, gpm.getGpmVillage());
			ps.setString(3, gpm.getGpmUser());
			ps.setString(4, gpm.getPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = gpm.getGpmName()+ " is added succesfully in Gram Panchayat Member list";
			}
			
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<GPM> getAllGramPanchayatMemeber() throws GPMException {
		
		List<GPM> gpms = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from gpm");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("Member_ID");
				String name = rs.getString("Member_Name");
				String vill = rs.getString("Memeber_Village");
				String user = rs.getString("Username");
				String pass = rs.getString("Password");
				
				GPM gpm = new GPM(id, name, vill, user, pass);
				
				gpms.add(gpm);
				
			}
			
			if(gpms.size() == 0) {
				throw new GPMException("You don't have any Gram Panchayat Member");
			}
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		return gpms;
		
	}

	@Override
	public GPM loginasAGPM(String user, String pass) throws GPMException {
		
		GPM gpm = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from gpm where username = ? and password = ?");
			
			ps.setString(2, pass);
			
			ps.setString(1, user);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("Member_ID");
				String name = rs.getString("Member_Name");
				String village = rs.getString("Memeber_Village");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				
				gpm = new GPM(id, name, village, username, password);
				
			}
			else {
				throw new GPMException("Invalid credential with Username "+user);
			}
			
		} catch (SQLException e) {
			
			throw new GPMException(e.getMessage());
			
		}
		
		
		
		
		return gpm;
	}

	@Override
	public String allocateEmployeeToProject(int empID, int projectID, int days, int wages, int memberID) throws EmployeeException, ProjectException {
		
		String message = "Not Allocated.....!!";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select * from project where project_Id = ?");
			
			ps1.setInt(1, projectID);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				
				String projectName = rs1.getString("Project_Name");
				
				PreparedStatement ps2 = conn.prepareStatement("select * from employee where Employee_ID = ?");
				
				ps2.setInt(1, empID);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					String employeeName = rs2.getString("Employee_Name");
					
					PreparedStatement ps3 = conn.prepareStatement("insert into Employee_Project values (?, ?, ?, ?, ?, ?, ?)");
					
					ps3.setInt(2, projectID);
					ps3.setInt(1, empID);
					ps3.setInt(3, days);
					ps3.setInt(4, wages);
					ps3.setInt(5, memberID);
					ps3.setString(6, employeeName);
					ps3.setString(7, projectName);
					
					int x = ps3.executeUpdate();
					
					if(x > 0) {
						message = projectName+" is assigned to "+employeeName;
					}
					
				}
				else {
					throw new EmployeeException("Employee doesn't exists with ID : "+empID);
				}
				
			}
			else {
				throw new ProjectException("Project doesn't exists with ID : "+projectID);
			}
			
			
		} catch (SQLException e) {
			
			throw new ProjectException(e.getMessage());
			
		}
		
		
		return message;
		
	}

	@Override
	public String numberOfDaysWorked(int id) throws GPMException {
		
		String message = "No work";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select employeeID, employee_Name, Numer_Of_Days, Wages_Per_Days from employee_project where Member_ID = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			boolean flag = true;
			while(rs.next()) {
				
				String name = rs.getString("employee_Name");
				int days = rs.getInt("Numer_Of_Days");
				int wages = rs.getInt("Wages_Per_Days");
				
				message = name+" has worked "+days+" days with "+wages+"RS per day";
				flag = false;
				
			}
			
			if(flag == true) {
				throw new GPMException("No employee is present for you");
			}
			
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		
		return message;
		
	}
	
	
	
	
}
