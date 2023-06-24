package com.jdbcdemo.main;

import java.sql.*;
import java.util.Scanner;

public class InsertProduct {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name of "
				+ "new product : ");
		String name = sc.next();
		
		System.out.print("Enter price of "
				+ "new product : ");
		int prc = sc.nextInt();
		
		try {
			//1) load the database Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2) get Connection with the database
			Connection con = 
					DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/14thmarchadv"
			,"root", "root");
			
			//3) create Statement to execute query
			PreparedStatement  st = 
			con.prepareStatement("INSERT INTO "
			+ "product(pname,price) VALUES(?,?)");
			
			st.setString(1, name);
			st.setInt(2, prc);
			
			//4) execute the query
			int count = st.executeUpdate();
			
			if(count > 0) {
				System.out.println("new product "
						+ "added");
			}
			else
				System.out.println("insertion of "
						+ "product failed");
			
			//7) close the database Connection
			con.close();
		}
		catch(SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
