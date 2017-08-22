package festival;

import java.time.LocalTime;

public class Act {
	private Band band;
	private LocalTime startTime;
	private LocalTime endTime;

	public Act(Band band, LocalTime startTime, LocalTime endTime) {
		this.band = band;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void start() {
		System.out.println("---" + this.band.getBandName() + " started playing---");
		this.band.play();
		System.out.println("---" + this.band.getBandName() + " finished playing---");
	}
}
