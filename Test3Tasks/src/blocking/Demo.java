package blocking;

public class Demo {

	public static void main(String[] args) {
		try {
			GasStation shell = new GasStation("Shell");
			CarGenerator cg = new CarGenerator(shell);
			FuelBoy f1 = new FuelBoy("stavri", shell);
			cg.start();
			f1.start();
		} catch (InvalidGasStationException e) {
			System.out.println("ops!");
		}
	}
}
