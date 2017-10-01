package hr;

import java.util.List;

public class Demo {
	public static void main(String[] args) {
		DBManager manager = DBManager.getInstance();
		List<Employee> employees = manager.printEmployees();
		System.out.println(employees);
		manager.printEmployees("King", 1000, 100000);
		manager.createCountry();
		manager.insertCountry("Afghanistan");
		manager.insertCountry("Canada");
		manager.insertCountry("USA");
		List<Country> countries = manager.listAllCountries();
		System.out.println(countries);
		Country countryById = manager.findCountryById(2);
		System.out.println(countryById);
		Country countryByPart = manager.findCountryByPartOfName("ana");
		System.out.println(countryByPart);
		manager.dropCountriesTable();
		
		List<Employee> fullEmployees = manager.printEmployeesFull();
		System.out.println(fullEmployees);
		List<Employee> employeesDepts = manager.getEmployeesByDepartment("Executive");
		System.out.println(employeesDepts);
		manager.createTableUsers();
		manager.createTableGroups();
		manager.addUser(new User("Lucho", 1));
		manager.addUser(new User("Toni", 2));
		manager.addUser(new User("Blagoy", 2));
		manager.addGroup(new Group("Colleagues"));
		List<User> allUsers = manager.listAllUsers();
		System.out.println(allUsers);
		List<Group> allGroups = manager.listAllGroups();
		System.out.println(allGroups);
		List<User> usersByGroup = manager.listAllUsersByGroup("Colleagues");
		System.out.println(usersByGroup);
		User blago = new User(4, "Blagoyski", 2);
		manager.updateUser(blago);
		Group colleagues = new Group(2, "Colleaguesssss");
		manager.updateGroup(colleagues);
		manager.deleteUser(new User(6, "username", 2));
		manager.deleteGroup(new Group(3, "iztroshlqci"));
		manager.dropTableUsers();
		manager.dropTableGroups();
	}
}
