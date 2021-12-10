package com.xoriant.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconfig {

	 static Connection conn=null;
	
	public static Connection getConnection(){
	
		if(conn==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/amzoncart","root","root");
				System.out.println("======== Connection Created Succesfully ========");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
}
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		getConnection();
	}
}
