package com.bridgelabz.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementIN {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bridgelabz";
		String user = "root";
		String pass = "password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		int id = 22;
		String name = "radheshyam";
		java.sql.CallableStatement cst = con.prepareCall("{CALL `bridgelabz`.`insertData`(?,?)}");
		cst.setInt(1, id);
		cst.setString(2, name);
		int count = cst.executeUpdate();

		
		System.out.println(count + " row/s affected");

		cst.close();
		con.close();
	}

}
