package com.jdbcdemo.main;

import java.sql.*;

public class ScrollUpdateDemo {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = 
					DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/14thmarchadv"
			,"root", "root");
			
			PreparedStatement  st = 
			con.prepareStatement("SELECT * FROM"
					+ " product",
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)
				+ " : " + rs.getString("pname") + 
				" : " + rs.getInt(3));
			}
			
			if(rs.isAfterLast())
				System.out.println("rs is "
						+ "after last");
			
			rs.first();
			System.out.println("first product : ");
			System.out.println(rs.getInt(1)
			+ " : " + rs.getString("pname") + 
			" : " + rs.getInt(3));
			
			rs.last();
			System.out.println("last product : ");
			System.out.println(rs.getInt(1)
			+ " : " + rs.getString("pname") + 
			" : " + rs.getInt(3));
			
			rs.absolute(3);
			System.out.println("third product : ");
			System.out.println(rs.getInt(1)
			+ " : " + rs.getString("pname") + 
			" : " + rs.getInt(3));
			
			rs.previous();
			System.out.println("previous product : ");
			System.out.println(rs.getInt(1)
			+ " : " + rs.getString("pname") + 
			" : " + rs.getInt(3));
			
			rs.moveToInsertRow();
			rs.updateString("pname", "AC");
			rs.updateInt("price", 45000);
			rs.insertRow();
			
			System.out.println("After insertion , "
					+ "all products are : ");
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getInt(1)
				+ " : " + rs.getString("pname") + 
				" : " + rs.getInt(3));
			}
			
			rs.absolute(5);
			rs.updateString("pname", "Samsung AC");
			rs.updateInt("price", 54000);
			rs.updateRow();
			
			System.out.println("After updation , "
					+ "all products are : ");
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getInt(1)
				+ " : " + rs.getString("pname") + 
				" : " + rs.getInt(3));
			}
			
			rs.absolute(5);
			rs.deleteRow();
			
			System.out.println("After deletion , "
					+ "all products are : ");
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getInt(1)
				+ " : " + rs.getString("pname") + 
				" : " + rs.getInt(3));
			}
			
			con.close();
		}
		catch(SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
