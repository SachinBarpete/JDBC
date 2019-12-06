package com.bridgelabz.JDBC;

import java.sql.*;
/**
 * @author Sachin Barpete
 * @purpose insert data into student table using prepare statement 
 */
public class PrepareStatement {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bridgelabz";
		String user = "root";
		String pass = "password";
		int s_id = 15;
		String s_name = "prem";
		String query = "insert into student values (?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, s_id);
		pst.setString(2, s_name);
		int count = pst.executeUpdate();
		System.out.println(count + " row/s affected");
		pst.close();
		con.close();
	}

}
