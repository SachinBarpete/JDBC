package com.bridgelabz.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementINOUT {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bridgelabz";
		String user = "root";
		String pass = "password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		int id = 10;
		java.sql.CallableStatement cst = con.prepareCall("{CALL `bridgelabz`.`selectName`(?,?)}");
		cst.setInt(1, id);
		cst.executeUpdate();
		String name = cst.getString(2);
		System.out.println(name);
		
		System.out.println("run successfully");

		cst.close();
		con.close();
	}
}
