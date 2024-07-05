package com.EmployeeImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.Connection.ConnectionEstablish;
import com.EmployeeUnImp.EmployeeUnImp;

public class Employee implements EmployeeUnImp {
	
	@Override
	public void register() {
		
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter your ID:");
		 int id=sc.nextInt();
		 
		 System.out.println("Enter your Name:");
		 String n=sc.next();
		 
		 System.out.println("Enter your Salary:");
		 double s=sc.nextDouble();
        
		 System.out.println("Enter your Experience:");
		 double e=sc.nextDouble();
		 
		 try {
			 Connection con=ConnectionEstablish.createConnection();
			 PreparedStatement ps= con.prepareStatement("insert into Employee values(?,?,?,?)");
			 ps.setInt(1, id);
			 ps.setString(2, n);
			 ps.setDouble(3, e);
			 ps.setDouble(4, e);
			 int row=ps.executeUpdate();
			 System.out.println(row + "Affected ");
			 ps.close();
			 con.close();
		 }catch(Exception e1) {
			 e1.printStackTrace();
		 }
		
		 
	}

	@Override
	public void update() {
		try {
			Connection con=ConnectionEstablish.createConnection();
			System.out.println("Enter your id to  update salary:");
			Scanner sc=new Scanner(System.in); 
			
			int id= sc.nextInt();
			
			System.out.println("Enter your amount to update salary of"+ id + "Employee:");
			double s=sc.nextDouble();
			
			PreparedStatement ps= con.prepareStatement("update Employee set salary=? where id=?");
			
			ps.setDouble(1, s);
			ps.setInt(2, id);
			
			int row=ps.executeUpdate();
			 System.out.println(row + "Affected ");
			 ps.close();
			 con.close();
		 }catch(Exception e1) {
			 e1.printStackTrace();
		 }
		 
	}
			
		
		
	

	@Override
	public void fetch() {
		//select query
	try {
		Connection con=	ConnectionEstablish.createConnection();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the id for fetching into of employee:");
		int id=sc.nextInt();
		
		PreparedStatement ps=con.prepareStatement("Select *from Employee where id=?;");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getDouble(3));
		System.out.println(rs.getDouble(4));
		}
	
	ps.close();
	con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void terminated() {
		try {
			Connection con=ConnectionEstablish.createConnection();
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter id which you want terminate the employee:");
			int id=sc.nextInt();
			
			PreparedStatement ps=con.prepareStatement("Delete from employee where id=?");
			ps.setInt(1, id);
			int row=ps.executeUpdate();
			if(row==0) {
				System.out.println(row +"employee is not terminated");
			}else {
				System.out.println(row +"employee is a terminated");
			}
			ps.close();
			con.close();
		}catch(Exception e1) {
			 e1.printStackTrace();
	   }
	}

	@Override
	public void fetchallDetails() {
		
		try {
			Connection con=	ConnectionEstablish.createConnection();
			Statement st= con.createStatement();
	
			ResultSet rs=st.executeQuery("Select* from Employee");
			while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getDouble(4));
			}
		
		st.close();
		con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		}
	}
		

	
