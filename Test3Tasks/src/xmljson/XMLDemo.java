package xmljson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

public class XMLDemo {
	public static void main(String[] args) {
		CarShop shop = new CarShop("Talents", "Infinity Tower");
		shop.addCar(new Car("BMW", "M4", 450, 320, 3.6));
		shop.addCar(new Car("Subaru", "Impreza WRX STI", 350, 290, 2.5));
		shop.addCar(new Car("Nissan", "GT-R R35", 600, 320, 3.8));
		
		try {
			serializeShopToXML(shop);
		} catch (IOException e) {
			System.out.println("Could not serialize shop to XML");
			e.printStackTrace();
		}
		
		serializeFromXML();
	}
	
	public static void serializeShopToXML(CarShop shop) throws IOException {
		XStream stream = new XStream();
		String shopxml = stream.toXML(shop);
		
		File f = new File("CarShop.xml");
		if (!f.exists()) {
			f.createNewFile();
		}
		
		try(FileWriter writer = new FileWriter(f);) {
			writer.write(shopxml);
			writer.flush();
		}
	}
	
	public static void serializeFromXML(){
		File f = new File("ep8.xml");
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
		
		XStream stream = new XStream();
		Object episode8 = stream.fromXML(sb.toString());
		System.out.println(episode8.toString());
	}
}
