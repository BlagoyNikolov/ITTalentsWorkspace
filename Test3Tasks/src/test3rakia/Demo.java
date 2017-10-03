package test3rakia;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		Village v = new Village();
		ArrayList<Berach> berachi = new ArrayList<Berach>();
		for (int i = 0; i < 7; i++) {
			berachi.add(new Berach("b" + i, 45, v.getRandomKazan()));
		}
		
		ArrayList<RakiaMan> rakiamen = new ArrayList<RakiaMan>();
		for (int i = 0; i < 3; i++) {
			rakiamen.add(new RakiaMan("r" + i, 45, v.getRandomKazan()));
		}
		
		for (Berach berach : berachi) {
			berach.start();
		}
		
		for (RakiaMan rakiaMan : rakiamen) {
			rakiaMan.start();
		}
		
		v.startLogging();
	}
}
