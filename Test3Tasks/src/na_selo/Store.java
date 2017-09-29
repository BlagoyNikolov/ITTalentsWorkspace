package na_selo;

import java.util.HashMap;

public class Store {

	public enum Stoki{
		RAKIQ, KOMPOT;
	}
	
	private String name;
	private static final int MAX_CAPACITY = 100;
	private static final int MIN_CAPACITY = 0;
	private HashMap<Stoki, Integer> raft;
	
	public Store(String name) {
		this.name = name;
		raft = new HashMap<>();
		
		for (int i = 0; i < Stoki.values().length; i++) {
			raft.put(Stoki.values()[i], 0);
		}
	}
	
	public synchronized void add(Stoki stoka, int kg){
		while(this.raft.get(stoka) + kg > MAX_CAPACITY){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Nqma mqsto v magazina za " + stoka);
			}
		}
		this.raft.put(stoka, raft.get(stoka) + kg);
		System.out.println("Dobavihme " + kg + " broq "+ stoka);
		notifyAll();
	}
	
	public synchronized void get(Stoki stoka, int kg){
		while(this.raft.get(stoka) < kg){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Nqma nalichno v magazina " + stoka);
			}
		}
		this.raft.put(stoka, raft.get(stoka) - kg);
		System.out.println("Vzehme " + kg + " broq "+ stoka);
		notifyAll();
	}
	
	public int getRakii(){
		return raft.get(Stoki.RAKIQ);
	}
	public int getKompoti(){
		return raft.get(Stoki.KOMPOT);
	}
}
