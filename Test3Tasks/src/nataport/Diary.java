package nataport;

import java.time.LocalDateTime;

public class Diary implements Comparable<Diary> {
	private int pratkaId;
	private int dockId;
	private String shipName;
	private int kranId;
	private LocalDateTime date;

	public Diary(int pratkaId, int dockId, String shipName, int kranId, LocalDateTime date) {
		this.pratkaId = pratkaId;
		this.dockId = dockId;
		this.shipName = shipName;
		this.kranId = kranId;
		this.date = date;
	}

	public int getPratkaId() {
		return pratkaId;
	}

	public void setPratkaId(int pratkaId) {
		this.pratkaId = pratkaId;
	}

	public int getDockId() {
		return dockId;
	}

	public void setDockId(int dockId) {
		this.dockId = dockId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public int getKranId() {
		return kranId;
	}

	public void setKranId(int kranId) {
		this.kranId = kranId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int compareTo(Diary o) {
		return this.date.compareTo(o.getDate());
	}

	@Override
	public String toString() {
		return "Diary [pratkaId=" + pratkaId + ", dockId=" + dockId + ", shipName=" + shipName + ", kranId=" + kranId
				+ ", date=" + date + "]";
	}
}
