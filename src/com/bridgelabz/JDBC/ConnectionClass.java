package com.bridgelabz.JDBC;

import java.sql.*;

public class ConnectionClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/bridgelabz";
		String user = "root";
		String pass = "password";
		String query = "select * from student";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		
		// statement
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		String userData = "";
		while (rs.next()) {
			userData = rs.getInt(1) + " : " + rs.getString(2);
			System.out.println(userData);
		}

		st.close();
		con.close();
	}
}
