package na_selo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	
	private static final String DB_IP = "192.168.8.22";
	private static final String DB_PORT = "3306";
	private static final String DB_DBNAME = "hr";
	private static final String DB_USER = "ittstudent";
	private static final String DB_PASS = "ittstudent-123";

	public static void main(String[] args) {
		Bidon b1 = new Bidon();
		Berachi ber1 = new Berachi("Siika", b1);
		Berachi ber2 = new Berachi("Ginka", b1);
		Store store = new Store("Kaufland");
		Rakidjiq r1 = new Rakidjiq("bai Pencho", b1, store);
		Piinqk p1 = new Piinqk("Zlatan", store);
		Jena j1 = new Jena("Vaska", b1, store, p1);
		
		ber1.start();
		ber2.start();
		r1.start();
		p1.start();
		j1.start();
		writeToDb(store);
	}
	
	static void writeToDb(Store store){
		Thread t = new Thread(()->{
			int day = 0;
			while (true){
				try {
					Thread.sleep(10000);
					++day;
				} catch (Exception e) {
					System.out.println("opa");
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver not found or failed to load. Check your libraries");
				}
				Connection connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
					connection.setAutoCommit(false);
					PreparedStatement stmt = connection.prepareStatement("INSERT INTO rakii (den, prodadena_rakiya, prodadeni_burkani) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, day);
					stmt.setInt(2, store.getRakii());
					stmt.setInt(3, store.getKompoti());
					stmt.executeUpdate();

				} catch (SQLException e) {
					System.out.println("Connection failed to open. Reason: " + e.getMessage());
				}finally {
					try {
						connection.setAutoCommit(true);
						//
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t.setDaemon(true);
		t.start();
	}
}
