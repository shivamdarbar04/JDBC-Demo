package com.jdbcdemo.main;

import java.sql.*;

public class MetaDataDemo {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = 
					DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/14thmarchadv"
			,"root", "root");
			
			PreparedStatement  st = 
			con.prepareStatement("SELECT * FROM"
					+ " product");
			
			ResultSet rs = st.executeQuery();
	
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int count = rsmd.getColumnCount();
			
			System.out.println("total columns : " +
			count);
			
			System.out.println("name of database : "
					+ rsmd.getCatalogName(1));
			
			System.out.println("name of table : "
					+ rsmd.getTableName(1));
			
			for(int i = 1 ; i <= count ; i++) {
				
				System.out.println(
				rsmd.getColumnName(i) + " : "
				+ rsmd.getColumnTypeName(i) + " : "
				+ rsmd.getColumnClassName(i));
			}
			
			con.close();
		}
		catch(SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
