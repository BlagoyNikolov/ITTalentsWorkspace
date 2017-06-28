package lesson11;

public class Izpitvanki {

	public static void main(String[] args) {
		
		int n = 10;
		int counter = 0;
		for (int j = 0; j < n; j++) {
			if(counter >= n){
				break;
			}
			for (int i =0 ; i < 5*n; i++) {
				counter++;
			}	
		}
		
	}
}
