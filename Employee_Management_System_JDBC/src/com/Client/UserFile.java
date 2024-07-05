package com.Client;

import java.util.Scanner;

import com.EmployeeImp.Employee;

public class UserFile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Employee emp=new Employee();
		
		boolean flag=true;
		while(flag) {
			
			System.out.println("Enter your Choice");
			System.out.println("1].Registration");
			System.out.println("2].Update Salary");
			System.out.println("3].Fetch salary");
			System.out.println("4].Resignation salary");
			System.out.println("5].FetchingallDetails");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:emp.register();
			       
			 break;
			 
			case 2:emp.update();
		       
		    break;
		    
			case 3:emp.fetch();
		      
		     break;
		     
			case 4:emp.terminated();
		  
		    break;
		    
			case 5:emp.fetchallDetails();
			
			break;
		    
		    
		    default:System.out.println("Thank you");
		            flag=false;
		            break;
		            
		      
		 
			}
		}

		}
	

}
