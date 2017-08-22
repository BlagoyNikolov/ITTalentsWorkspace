package festival;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		TreeSet<Band> bands = new TreeSet<>();
		Band band1 = new Band("Band1", fillBand(), fillSongs());
		Band band2 = new Band("Band2", fillBand(), fillSongs());
		Band band3 = new Band("Band3", fillBand(), fillSongs());
		bands.add(band1);
		bands.add(band2);
		bands.add(band3);

		MusicFestival mf = new MusicFestival("Talent Festival", "Infinity Tower", LocalDate.of(2017, Month.AUGUST, 10), bands);
		
		mf.addAct(new Act(band1, LocalTime.of(19, 00), LocalTime.of(20, 00)));
		mf.addAct(new Act(band2, LocalTime.of(20, 00), LocalTime.of(21, 00)));
		mf.addAct(new Act(band3, LocalTime.of(21, 00), LocalTime.of(22, 00)));
		
		mf.execute();
		
		//printBands(bands);
	}
	
	public static void printBands(TreeSet<Band> bands) {
		for (Iterator iterator = bands.iterator(); iterator.hasNext();) {
			Band band = (Band) iterator.next();
			band.printBandProperties();
		}
	}

	private static HashSet<Song> fillSongs() {
		HashSet<Song> bandSongs = new HashSet<>();
		for (int i = 0; i < new Random().nextInt(5) + 1; i++) {
			bandSongs.add(new Song("Song" + i, "Song" + i + "text"));
		}
		return bandSongs;
	}

	private static HashSet<Musician> fillBand() {
		HashSet<Musician> bandMusicians = new HashSet<>();
		addMusicians(bandMusicians);
		return bandMusicians;
	}

	private static void addMusicians(HashSet<Musician> band) {
		for (int i = 0; i < 3; i++) {
			int x = new Random().nextInt(2);
			switch (x) {
			case 0:
				band.add(new Vocalist("vocalist" + i));
				break;
			case 1:
				band.add(new Instrumentalist("instrumentalist" + i));
				break;
			default:
				break;
			}
		}
	}
}
