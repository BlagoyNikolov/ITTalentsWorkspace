package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

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
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
				Statement stmt = connection.createStatement();) {

			ResultSet result = stmt.executeQuery("SELECT age, name FROM javari WHERE gender = 'F' AND AGE < 22;");
			while (result.next()) {
				String name = result.getString("name");
				int age = result.getInt("age");
				System.out.println(name + " - " + age);
			}
		} catch (SQLException e) {
			System.out.println("Connection failed to open. Reason: " + e.getMessage());
		}

	}
}
