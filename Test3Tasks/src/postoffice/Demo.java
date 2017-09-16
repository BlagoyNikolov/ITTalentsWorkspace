package postoffice;

import java.util.HashSet;
import java.util.Random;

import postoffice.post.Gatherer;
import postoffice.post.MailBox;
import postoffice.post.MailStation;
import postoffice.shipments.Colette;
import postoffice.shipments.Letter;

public class Demo {
	public static void main(String[] args) {
		HashSet<MailBox> mailBoxes = new HashSet<>();
		for (int i = 0; i < 25; i++) {
			mailBoxes.add(new MailBox("MilboxAddr" + i));
		}
		MailStation station = new MailStation(mailBoxes);
		
		Citizen jonDoe = new Citizen("Jon", "Doe", "asdaw");
		Citizen janeDoe = new Citizen("Jane", "Doe", "sada");
		
		Letter l1 = new Letter(jonDoe, janeDoe);
		Letter l2 =  new Letter(janeDoe, jonDoe);
		jonDoe.addLetter(l1);
		janeDoe.addLetter(l2);
		
		Colette c1 = new Colette(jonDoe, janeDoe, new Random().nextInt(60)+10, new Random().nextInt(60)+10, new Random().nextInt(60)+10, true);
		Colette c2 =  new Colette(janeDoe, jonDoe, new Random().nextInt(60)+10, new Random().nextInt(60)+10, new Random().nextInt(60)+10, false);
		jonDoe.addColette(c1);
		janeDoe.addColette(c2);
		
		jonDoe.printColettes();
		janeDoe.printLetters();
		
		jonDoe.dropColetteAtStation(station);
		jonDoe.dropLetterAtStation(station);
		
		janeDoe.dropLetterInBox(station.getRandomBox());
		
		janeDoe.printLetters();
		
		station.printArchive();
		station.printRepository();
		
		station.printMailBoxesContent();
		
		Gatherer g = new Gatherer("G1", "L1", 5, station.getRandomBox());
		station.addGatherer(g);
		g.getBoxContent();
		
		station.addGathererLettersToStation();
		
		station.printArchive();
		station.printRepository();
		
		station.printMailStationStats();
	}
}
