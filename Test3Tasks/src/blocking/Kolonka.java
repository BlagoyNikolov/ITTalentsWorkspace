package blocking;

import java.util.LinkedList;
import java.util.Queue;

public class Kolonka {

	private static final int MAX_CARS_IN_LINE = 10;
	private static final int MIN_CARS_IN_LINE = 0;
	private Queue<Car> opashchica = new LinkedList<>();
	
	
	public void addCar(Car c){
		while(opashchica.size() >= MAX_CARS_IN_LINE){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		opashchica.offer(c);
	}
	
	public Car removeCar(){
		while(opashchica.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("no car for me damn..");
			}
		}
		return opashchica.poll();
	}
	
	public boolean isEmpty(){
		return opashchica.size() == 0;
	}
	
}
