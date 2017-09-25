package carfactory;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Factory {
	public static void main(String[] args) {
		ArrayList<Runnable> tasks = new ArrayList<>();
		tasks.add(new Engine()); //7
		tasks.add(new Frame());  //5
		tasks.add(new Seat());   //3
		tasks.add(new Seat());	 //3
		tasks.add(new Seat());   //3
		tasks.add(new Seat());   //3
		tasks.add(new Seat());   //3
		tasks.add(new Tire());   //2
		tasks.add(new Tire());   //2
		tasks.add(new Tire());   //2
		tasks.add(new Tire());   //2
		
		ExecutorService assemblyLine = Executors.newFixedThreadPool(5);
		ArrayList<Future> futures = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (Runnable r : tasks) {
			futures.add(assemblyLine.submit(r));
		}

		boolean done = false;
		while (true) {
			for (Future future : futures) {
				done = future.isDone() ? (done = true) : (done = false);
			}
			if (done) {
				break;
			}
		}
		assemblyLine.shutdown();
		System.out.println("Time " + (System.currentTimeMillis() - start));
	}
}
