package test3rakia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Logger {
	DBManager manager = DBManager.getInstance();
	Connection connection = DBManager.getConnection();
	Kazan kazan;
	
	public void insertRakijiq(RakiaMan r) {
		String name = r.getPersonName();
		int age = r.getPersonAge();
		String query = "INSERT INTO rakia_men (name, age) VALUES (?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertRakijiq(Berach b) {
		String name = b.getPersonName();
		int age = b.getPersonAge();
		String query = "INSERT INTO berachi (name, age) VALUES (?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addRakiiToDB() {
		for (Rakia r : this.kazan.getRakii()) {
			insertRakia(r);
		}
	}
	
	public void insertRakia(Rakia r) {
		String maker = r.getMaker();
		int quantity = r.getQuatity();
		FruitType type = r.getFruitType();
		LocalDateTime date = r.getDate();
		String query = "INSERT INTO rakii (date, type, maker, quantity) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setTimestamp(1, Timestamp.valueOf(date));
			statement.setString(2, type.toString());
			statement.setString(3, maker);
			statement.setInt(4, quantity);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getRakiiQuantity() {
		String query = "SELECT type, SUM(quantity) AS quantity FROM hr.rakii GROUP BY type";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				String type = results.getString("type");
				int quantity = results.getInt("quantity");
				System.out.println(type + " " + quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getBestRakijiq() {
		String query = "SELECT maker, MAX(quantity) AS quantity FROM hr.rakii";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			String name = results.getString("maker");
			int quantity = results.getInt("quantity");
			System.out.println("The best rakijiq is " + name + " with " + quantity);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getYoungestRakijiq() {
		String query = "SELECT name, MIN(age) AS age FROM hr.berachi";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			String name = results.getString("name");
			int age = results.getInt("age");
			System.out.println("The youngest berach is " + name + " who is " + age);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
