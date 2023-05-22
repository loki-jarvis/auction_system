package com.auctionsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSystem", "root", "root@123");
			System.out.println("connected");
		}
		
		return connection;
		
	}

}
