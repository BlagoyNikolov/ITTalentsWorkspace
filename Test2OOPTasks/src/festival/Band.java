package festival;

import java.util.HashSet;

public class Band implements Comparable<Band> {
	private String bandName;
	private HashSet<Musician> musicians;
	private HashSet<Song> songs;
	private boolean hasVocalist;
	
	public Band(String bandName) {
		this.bandName = bandName;
		this.setHasVocalist();
	}
	
	public Band(String bandName, HashSet<Musician> musicians) {
		this.bandName = bandName;
		this.musicians = musicians;
		this.setHasVocalist();
	}
	
	public Band(String bandName, HashSet<Musician> musicians, HashSet<Song> songs) {
		this.bandName = bandName;
		this.musicians = musicians;
		this.songs = songs;
		this.setHasVocalist();
	}
	
	public String getBandName() {
		return bandName;
	}
	
	public void setMusicians(HashSet<Musician> musicians) {
		this.musicians = musicians;
	}
	
	public HashSet<Song> getSongs() {
		return songs;
	}
	
	public void setSongs(HashSet<Song> songs) {
		this.songs = songs;
	}
	
	public void setHasVocalist() {
		for (Musician musician : musicians) {
			if (musician instanceof Vocalist) {
				this.hasVocalist = true;
			}
		}
	}

	@Override
	public int compareTo(Band o) {
		return this.bandName.compareTo(o.bandName);
	}
	
	public void play() {
		for (Song song : songs) {
			System.out.println("Song " + song.getTitle());
			for (Musician musician : musicians) {
				if (hasVocalist) {
					if (musician instanceof Vocalist) {
						Musician v = (Vocalist)musician;
						v.playMusic();
					} else {
						Musician i = (Instrumentalist)musician;
						i.playMusic();
					}
				}
			}
		}
	}
	
	public void printBandProperties() {
		System.out.println("Band name " + this.bandName);
		System.out.println("---Artists---");
		for (Musician musician : musicians) {
			System.out.println(musician);
		}
		System.out.println("---Songs---");
		for (Song song : songs) {
			System.out.println(song);
		}
		System.out.println("_____________");
	}
}
