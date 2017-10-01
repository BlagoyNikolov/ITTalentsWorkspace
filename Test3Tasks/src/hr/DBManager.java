package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	private static final String DB_IP = "127.0.0.1";
	private static final String DB_PORT = "3306";
	private static final String DB_DBNAME = "hr";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";
	
	private static DBManager instance;
	private static Connection connection;

	private DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Not having a Driver");
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public List<Employee> printEmployees() {
		String sql = "SELECT employee_id, first_name, last_name, salary FROM hr.employees";
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double salary = rs.getDouble("salary");
				Employee employee = new Employee(employeeId, firstName, lastName, salary);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return employees;
	}
	
	public void printEmployees(String lastNameParam, double salaryMin, double salaryMax) {
		String sql = "SELECT first_name, last_name, salary FROM hr.employees WHERE last_name = '" + lastNameParam +
				"' AND salary > " + salaryMin +" AND salary < " + salaryMax;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double salary = rs.getDouble("salary");
				System.out.println(firstName + " " + lastName + " " + salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
	}
	
	public void createCountry() {
		String query = "CREATE TABLE COUNTRIESJAVA (country_id INTEGER NOT NULL AUTO_INCREMENT, country_name NVARCHAR(50) UNIQUE NOT NULL, CONSTRAINT country_pk PRIMARY KEY(country_id))";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertCountry(String name) {
		String query = "INSERT INTO countriesjava (country_name) VALUES ('" + name + "')";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
	}
	
	public List<Country> listAllCountries() {
		List<Country> countries = new ArrayList<Country>();
		String query = "SELECT country_id, country_name FROM countriesjava";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("country_id");
				String name = rs.getString("country_name");
				Country c = new Country(id, name);
				countries.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return countries;
	}
	
	public Country findCountryById(int id) {
		String query = "SELECT country_id, country_name FROM countriesjava WHERE country_id = " + id;
		PreparedStatement statement = null;
		Country country = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int countryId = rs.getInt("country_id");
				String name = rs.getString("country_name");
				country = new Country(countryId, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return country;
	}
	
	public Country findCountryByPartOfName(String part) {
		String query = "SELECT country_id, country_name FROM countriesjava WHERE country_name LIKE '%" + part + "%'";
		PreparedStatement preparedStatement = null;
		Country country = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int countryId = resultSet.getInt("country_id");
				String name = resultSet.getString("country_name");
				country = new Country(countryId, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return country;
	}
	
	public void dropCountriesTable() {
		String query = "DROP TABLE countriesjava";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Employee> printEmployeesFull() {
		String query = "SELECT e.first_name, e.last_name, m.first_name AS man_fn, m.last_name AS man_ln, department_name FROM employees AS e JOIN employees AS m ON e.manager_id = m.employee_id JOIN departments ON e.department_id = departments.department_id";
		PreparedStatement statement = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				String firstName = results.getString("first_name");
				String lastName = results.getString("last_name");
				String mFirstName = results.getString("man_fn");
				String mLastName = results.getString("man_ln");
				String departmentName = results.getString("department_name");
				Employee employee = new Employee(firstName, lastName, mFirstName, mLastName, departmentName);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}
	
	public List<Employee> getEmployeesByDepartment(String departmentName) {
		String query = "SELECT first_name, last_name, salary, department_name FROM hr.employees JOIN hr.departments ON employees.department_id = departments.department_id WHERE department_name = '" + departmentName + "';";
		PreparedStatement statement = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				double salary = resultSet.getDouble("salary");
				String department = resultSet.getString("department_name");
				Employee employee = new Employee(firstName, lastName, department, salary);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}
	
	public void createTableUsers() {
		String query = "CREATE TABLE USERSJAVA (user_id INTEGER NOT NULL AUTO_INCREMENT, user_name NVARCHAR(50), group_id INTEGER, CONSTRAINT user_pk PRIMARY KEY(user_id))";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Successfully created table USERSJAVA");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createTableGroups() {
		String query = "CREATE TABLE GROUPSJAVA (group_id INTEGER NOT NULL AUTO_INCREMENT, group_name NVARCHAR(50), CONSTRAINT group_pk PRIMARY KEY(group_id))";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
			System.out.println("Successfully created table GROUPSJAVA");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addUser(User user) {
		String username = user.getUsername();
		int groupId = user.getGroupId();
		String query = "INSERT INTO USERSJAVA (user_name, group_id) VALUES ('" + username + "', " + groupId + ")";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addGroup(Group group) {
		String groupName = group.getGroupName();
		String query = "INSERT INTO GROUPSJAVA (group_name) VALUES ('" + groupName + "')";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<User> listAllUsers() {
		String query = "SELECT user_id, user_name, group_id FROM hr.usersjava";
		List<User> users = new ArrayList<User>();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				int userId = results.getInt("user_id");
				String userName = results.getString("user_name");
				int groupId = results.getInt("group_id");
				User user = new User(userId, userName, groupId);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<Group> listAllGroups() {
		String query = "SELECT group_id, group_name FROM hr.groupsjava";
		List<Group> groups = new ArrayList<Group>();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				int groupId = results.getInt("group_id");
				String groupName = results.getString("group_name");
				Group group = new Group(groupId, groupName);
				groups.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	public List<User> listAllUsersByGroup(String groupName) {
		String query = "SELECT user_id, user_name, group_name FROM hr.usersjava JOIN groupsjava ON usersjava.group_id = groupsjava.group_id WHERE group_name = '" + groupName + "'";
		List<User> users = new ArrayList<User>();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				String userName = results.getString("user_name");
				String group = results.getString("group_name");
				User user = new User(userName, group);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateUser(User user) {
		int userId = user.getUserId();
		String username = user.getUsername();
		int groupId = user.getGroupId();
		String query = "UPDATE USERSJAVA SET user_name = '" + username + "', group_id = " + groupId + " WHERE user_id = " + userId;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateGroup(Group group) {
		int groupId = group.getGroupId();
		String name = group.getGroupName();
		String query = "UPDATE GROUPSJAVA SET group_name = '" + name + "' WHERE group_id = " + groupId;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteUser(User user) {
		int userId = user.getUserId();
		String query = "DELETE FROM usersjava WHERE user_id = " + userId;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteGroup(Group group) {
		int groupId = group.getGroupId();
		String query = "DELETE FROM groupsjava WHERE group_id = " + groupId;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dropTableUsers() {
		String query = "DROP TABLE usersjava";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dropTableGroups() {
		String query = "DROP TABLE groupsjava";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}