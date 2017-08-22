package festival;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class MusicFestival {
	private String name;
	private String address;
	private LocalDate time;
	private TreeSet<Band> bands;
	private ArrayList<Act> acts;
	
	public MusicFestival(String name, String address, LocalDate time, TreeSet<Band> bands) {
		this.name = name;
		this.address = address;
		this.time = time;
		this.bands = bands;
		this.acts = new ArrayList<Act>();
	}
	
	public void addAct(Act act) {
		this.acts.add(act);
	}
	
	public void execute() {
		for (Act act : acts) {
			System.out.println("--Act starting---");
			act.start();
			System.out.println("--Act end---\n");
		}
	}
}
