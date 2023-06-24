package com.jdbcdemo.main;

import java.sql.*;
import java.util.Scanner;

public class DeleteProduct {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter id of "
				+ "the product to be deleted : ");
		int id = sc.nextInt();
		
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
			con.prepareStatement("DELETE FROM product"
			+ " WHERE pid = ?");
			
			st.setInt(1, id);
			
			//4) execute the query
			int count = st.executeUpdate();
			
			if(count > 0) {
				System.out.println("product "
						+ "deleted");
			}
			else
				System.out.println("no such product"
						+ " found");
			
			//5) close the database Connection
			con.close();
		}
		catch(SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
