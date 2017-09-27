package nataport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.TreeMap;
import java.util.TreeSet;

public class DBManager {

	private static DBManager instance;

	private static Connection con;

	private DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Not having a Driver");
		}
		try {
			con = DriverManager.getConnection("", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public void insertDiaryIntoDB(Diary d) {
		String sql = "INSERT INTO port_shipments  (boat_name,dock_id,crane_id,unloading_time,package_id) VALUES (?,?,?,?,?);";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, d.getShipName());
			statement.setInt(2, d.getDockId());
			statement.setInt(3, d.getKranId());
			statement.setTimestamp(4, Timestamp.valueOf(d.getDate()));
			statement.setInt(3, d.getPratkaId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Can not add diary to DB");
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// dock_id~> diaries
	public TreeMap<Integer, TreeSet<Diary>> getAmountPackagesFromDB() {
		PreparedStatement ps = null;
		TreeMap<Integer, TreeSet<Diary>> statistics = new TreeMap<>();
		String sql = "SELECT dock_id,package_id,boat_name,crane_id,unloading_time from port_shipments";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Diary d = new Diary(rs.getInt("package_id"), rs.getInt("dock_id"), rs.getString("boat_name"),
						rs.getInt("crane_id"), rs.getTimestamp("unloading_time").toLocalDateTime());
				if (!statistics.containsKey(d.getDockId())) {
					statistics.put(d.getDockId(), new TreeSet());
				}
				statistics.get(d.getDockId()).add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return statistics;
	}

	public TreeMap<Integer, Integer> getSumOfPratkiFromDB() {
		// cran~> sumofpratki
		TreeMap<Integer, Integer> statistics = new TreeMap<>();
		String sql = "SELECT COUNT(package_id) AS pratki_crane from port_shipments WHERE crane_id =1";
		String sql2 = "SELECT COUNT(package_id) AS pratki_crane from port_shipments WHERE crane_id =2";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			statistics.put(1, rs.getInt("pratki_crane"));

			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			statistics.put(2, rs.getInt("pratki_crane"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return statistics;
	}

	public TreeMap<Integer, Integer> getSumOfShipsFromDB() {
		TreeMap<Integer, Integer> statistics = new TreeMap<>();
		String sql = "SELECT COUNT(boat_name) AS ships_in_dock from port_shipments WHERE dock_id =1";
		String sql2 = "SELECT COUNT(boat_name) AS ships_in_dock from port_shipments WHERE dock_id =2";
		String sql3 = "SELECT COUNT(boat_name) AS ships_in_dock from port_shipments WHERE dock_id =3";
		String sql4 = "SELECT COUNT(boat_name) AS ships_in_dock from port_shipments WHERE dock_id =4";
		String sql5 = "SELECT COUNT(boat_name) AS ships_in_dock from port_shipments WHERE dock_id =5";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			statistics.put(1, rs.getInt("ships_in_dock"));

			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			statistics.put(2, rs.getInt("ships_in_dock"));

			ps = con.prepareStatement(sql3);
			rs = ps.executeQuery();
			statistics.put(3, rs.getInt("ships_in_dock"));
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			statistics.put(4, rs.getInt("ships_in_dock"));
			
			ps = con.prepareStatement(sql5);
			rs = ps.executeQuery();
			statistics.put(5, rs.getInt("ships_in_dock"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return statistics;
	}

	public String getNameOfShipWithMOstPartki() {
		String sql = "SELECT  boat_name from port_shipments WHERE MAX(boat_name) ";
		PreparedStatement ps = null;
		String name = "";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			name = rs.getString("boat_name");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("sql exception");
			}
		}
		return name;
	}
}
