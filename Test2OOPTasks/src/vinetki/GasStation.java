package vinetki;

import java.util.ArrayList;
import java.time.LocalDate;

import vinetki.Vinette.ValidPeriod;
import vinetki.Vinette.VehicleType;

public class GasStation {
	private double income;
	private ArrayList<Vinette> vinettes;
	private LocalDate localDate;
	
	public GasStation() {
		this.vinettes = new ArrayList<Vinette>();
		this.localDate = LocalDate.of(2017, 1, 1);
		for (int i = 0; i < 10000; i++) {
			this.vinettes.add(new Vinette(this.localDate, Vinette.getRandomType(), Vinette.getRandomPeriod()));
		}
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setIncome(double income) {
		this.income = income;
	}
	
	public ArrayList<Vinette> getVinettes() {
		return vinettes;
	}
	
	public Vinette sellVinette(VehicleType type, ValidPeriod period) {
		for(Vinette v : this.getVinettes()) {
			if (v.getType().equals(type) && v.getPeriod().equals(period)) {
				Vinette soldVinette = v;
				this.setIncome(this.getIncome() + v.getPrice()) ;
				this.getVinettes().remove(v);
				return soldVinette;
			}
		}
		return null;
	}
}
