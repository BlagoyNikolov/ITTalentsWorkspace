package xmljson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONDemo {
	public static void main(String[] args) {
		CarShop shop = new CarShop("Talents", "Infinity Tower");
		shop.addCar(new Car("BMW", "M4", 450, 320, 3.6));
		shop.addCar(new Car("Subaru", "Impreza WRX STI", 350, 290, 2.5));
		shop.addCar(new Car("Nissan", "GT-R R35", 600, 320, 3.8));
		
		try {
			serializeShopToJSON(shop);
		} catch (IOException e) {
			System.out.println("Could not serialize shop to XML");
			e.printStackTrace();
		}
		
		readStarWars();
	}

	private static void serializeShopToJSON(CarShop shop) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(shop);
		
		File f = new File("CarShopJSON.json");
		if (!f.exists()) {
			f.createNewFile();
		}
		try(FileWriter writer = new FileWriter(f);) {
			writer.write(json);
			writer.flush();
		}
	}
	
	private static void readStarWars() {
		File f = new File("ep8.json");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		while(sc.hasNextLine()) {
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(sb.toString());
		JsonObject movie = element.getAsJsonObject();
		String title = movie.get("Title").getAsString();
		String year = movie.get("Year").getAsString();
		String plot = movie.get("Plot").getAsString();
		String poster = movie.get("Poster").getAsString();
		System.out.println(title);
		System.out.println(year);
		System.out.println(plot);
		System.out.println(poster);
	}
}
