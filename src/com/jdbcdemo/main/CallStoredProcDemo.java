package com.jdbcdemo.main;

import java.sql.*;
import java.util.Scanner;

public class CallStoredProcDemo {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter eno of "
				+ "employee : ");
		int num = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = 
					DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/14thmarchadv"
			,"root", "root");
			
			CallableStatement cs = 
			con.prepareCall("{call myproc(?,?)}");
			
			cs.setInt(1, num);
			
			cs.registerOutParameter(2, Types.CHAR);
			
			cs.execute();
			
			String dname = cs.getString(2); 
			
			System.out.println("name of department"
					+ " of the employee : " + 
					dname);
			
		 	con.close();
		}
		catch(SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
