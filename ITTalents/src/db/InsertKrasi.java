	package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertKrasi {

	private static final String DB_IP = "192.168.8.22";
	private static final String DB_PORT = "3306";
	private static final String DB_DBNAME = "hr";
	private static final String DB_USER = "ittstudent";
	private static final String DB_PASS = "ittstudent-123";

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found or failed to load. Check your libraries");
		}
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
			connection.setAutoCommit(false);
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO javari (name, age, gender) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "Slavcho");
			stmt.setInt(2, 27);
			stmt.setString(3, "M");
			stmt.executeUpdate();
			stmt = connection.prepareStatement("INSERT INTO javari (name, age, gender) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "Antonii");
			stmt.setInt(2, 27);
			stmt.setString(3, "M");
			stmt.executeUpdate();
			connection.commit();
			ResultSet keyResult = stmt.getGeneratedKeys();
			keyResult.next();
			long key = keyResult.getLong(1);
			System.out.println("Plamen is with id = " + key) ;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Connection failed to open. Reason: " + e.getMessage());
		}
				

	}

}
