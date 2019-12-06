package com.bridgelabz.JDBC;

import java.sql.*;

/**
 * @author Sachin Barpete
 * @purpose select all data from table using callableStatement 
 */
public class CallableStatement {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bridgelabz";
		String user = "root";
		String pass = "password";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		java.sql.CallableStatement cst = con.prepareCall("{CALL `bridgelabz`.`new_procedure`()}");
		ResultSet rs = cst.executeQuery();
		String userdata = "";
		while (rs.next()) {
			userdata = rs.getInt(1) + " : " + rs.getString(2);
			System.out.println(userdata);
		}
		cst.close();
		con.close();
	}
}
