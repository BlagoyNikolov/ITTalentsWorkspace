package test3lutenica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import test3lutenica.brigada.Baba;
import test3lutenica.brigada.Moma;
import test3lutenica.brigada.Momuk;
import test3lutenica.brigada.Person;
import test3lutenica.resources.Partida;
import test3lutenica.veggies.VegType;

public class Pisar extends Person implements Runnable {
	DBManager manager = DBManager.getInstance();
	Connection connection = DBManager.getConnection();
	private static Pisar instance;
	private static ArrayList<Momuk> momci;

	private Pisar(String name) {
		super(name, 40);
	}

	public void setMomci(ArrayList<Momuk> momci) {
		this.momci = momci;
	}

	public static synchronized Pisar getInstance() {
		if (instance == null) {
			instance = new Pisar("Logger");
		}
		return instance;
	}

	public void addLutenicaToLutenicaDB(Partida p, Baba b) {
		LocalDateTime date = p.getDate();
		int quantity = p.getQuantity();
		String babaName = b.getPersonName();

		String query = "INSERT INTO lutenica (date, quantity, baba_name) VALUES (?, ?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setTimestamp(1, Timestamp.valueOf(date));
			statement.setInt(2, quantity);
			statement.setString(3, babaName);
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

	public void addToNabrano(Moma m) {
		String momaName = m.getPersonName();
		VegType vegType = m.getVegType();
		int quantity = m.getQuantity();
		int momaAge = m.getAge();

		if (recordExists(m)) {
			String query = "UPDATE nabrano SET quantity = quantity + 1 WHERE moma_name = ? AND veggie_name = ?";
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, momaName);
				statement.setString(2, vegType.toString());
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
		} else { // no record
			String query = "INSERT INTO nabrano (moma_name, veggie_name, quantity, moma_age) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, momaName);
				statement.setString(2, vegType.toString());
				statement.setInt(3, quantity);
				statement.setInt(4, momaAge);
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
	}

	public boolean recordExists(Moma m) {
		VegType vegType = m.getVegType();
		String momaName = m.getPersonName();

		String query = "SELECT moma_name, veggie_name, quantity, moma_age FROM nabrano WHERE moma_name = ? AND veggie_name = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, momaName);
			statement.setString(2, vegType.toString());
			ResultSet results = statement.executeQuery();
			return results.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void writeToFile() {
		int counter = 0;
		while (true) {
			for (Momuk momuk : momci) {
				int seconds = momuk.getSecondsWorked();
				String momukName = momuk.getPersonName();
//				PrintStream ps;
//				try {
//					ps = new PrintStream(new File("momuksWork.txt"));
//					ps.println(momukName + " " + seconds);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
				FileWriter fw = null;
				try {
					fw = new FileWriter("momuksWork.txt", true);
					fw.write(momukName + " " + seconds + "\n");
					fw.write(String.format("%n"));
					fw.flush();
					counter++;
					if (counter == 5) {
						counter = 0;
						//getMomukNameAgeWithMaxQuantity();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/* Името и годините на момата, набрала най-голям брой зеленчуци. */
	// String query = "SELECT moma_name, moma_age FROM nabrano WHERE quantity =
	// (SELECT MAX(quantity) FROM nabrano)";
	public Moma getMomaNameAgeWithMaxVegs() {
		String momaName = "";
		int momaAge = 0;
		String query = "SELECT moma_name, moma_age FROM nabrano WHERE quantity = (SELECT MAX(quantity) FROM nabrano)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				momaName = results.getString(1);
				momaAge = results.getInt(2);
			}
			Moma moma = new Moma(momaName, momaAge);
			return moma;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/* Името на момъка, обработвал най-малко време. */
	public static void getMomukNameAgeWithMaxQuantity() {
		File momuksWork = new File("momuksWork.txt");
		try {
			Scanner sc = new Scanner(momuksWork);
			String curName = "";
			int curTime = 0;
			String minName = "";
			int minTime = Integer.MAX_VALUE;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] content = line.split(" ");
				String name = content[0];
				int time = Integer.parseInt(content[1]);
				curName = name;
				curTime = time;
				if (curTime < minTime) {
					minTime = curTime;
					minName = curName;
				}
			}
			System.out.println("-----Momuk with smallest quantity is " + minName + " with time of " + minTime);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Списък с партидите лютеница, групиран по дата, като за всяка дата се извежда
	 * колко броя партиди са произведени и колко общо килограма.
	 */
	public void getPartidi(/* ArrayList<Baba> allBabi */) {
		// ArrayList<Partida> allPartidi = new ArrayList<Partida>();
		// for (Baba baba : allBabi) {
		// allPartidi.addAll(baba.getPartidi());
		// }
		String date = "";
		int partidi = 0;
		int quantity = 0;
		String query = "SELECT date, COUNT(lutenica_id) as partidi, COUNT(quantity) as quantity FROM lutenica GROUP BY date";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				date = results.getString("date");
				partidi = results.getInt("partidi");
				quantity = results.getInt("quantity");
				System.out.println("Date " + date + " Number of partidi" + partidi + " " + quantity);
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

	/* Зеленчукът, набран най-много. */
	// String query = "SELECT veggie_name FROM nabrano WHERE quantity = (SELECT
	// MAX(quantity) FROM nabrano)";
	public void getMaxVeggie() {
		String vegName = "";
		int vegQuantity = 0;
		String query = "SELECT veggie_name, quantity FROM nabrano WHERE quantity = (SELECT MAX(quantity) FROM nabrano)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				vegName = results.getString(1);
				vegQuantity = results.getInt(2);
			}
			System.out.println("The vegetable with max quantity is " + vegName + " with quantity of " + vegQuantity);
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

	/* Бабата, произвела най-голямо количество лютеница. */
	public Baba getMaxBaba() {
		String babaName = "";
		int vegQuantity = 0;
		String query = "SELECT baba_name, quantity FROM lutenica WHERE quantity = (SELECT MAX(quantity) FROM lutenica)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				babaName = results.getString(1);
				vegQuantity = results.getInt(2);
			}
			Baba baba = new Baba(babaName, vegQuantity);
			return baba;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/* Средната възраст на всички участници в бригадата (без писаря). */

	@Override
	public void run() {
		// call all methods and sleep for 30 seconds
		writeToFile();
		//getMomukNameAgeWithMaxQuantity();
		try {
			Thread.sleep(30*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
