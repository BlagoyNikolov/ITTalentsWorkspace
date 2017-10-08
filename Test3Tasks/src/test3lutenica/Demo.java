package test3lutenica;

import java.util.ArrayList;

import test3lutenica.brigada.Baba;
import test3lutenica.brigada.Moma;
import test3lutenica.brigada.Momuk;
import test3lutenica.resources.Baraka;
import test3lutenica.resources.Kuhnq;
import test3lutenica.veggies.VegType;

public class Demo {
	public static void main(String[] args) {
		Baraka baraka = new Baraka();
		Kuhnq kuhnq = new Kuhnq();
		ArrayList<Moma> momi = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			momi.add(new Moma("Moma" + i, VegType.getRandomVegType(), baraka));
		}
		for (Moma moma : momi) {
			moma.start();
		}

		ArrayList<Momuk> momuci = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			momuci.add(new Momuk("Momuk" + i, baraka, kuhnq));
		}
		for (Momuk momuk : momuci) {
			momuk.start();
		}

		ArrayList<Baba> babi = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			babi.add(new Baba("Baba" + i, kuhnq));
		}
		for (Baba baba : babi) {
			baba.start();
		}

		Pisar pisar = Pisar.getInstance();
		pisar.setMomci(momuci);
		Thread t = new Thread(pisar);
		t.setDaemon(true);
		t.start();
		
		Thread t2 = new Thread(() -> {
			pisar.setMomci(momuci);
		});
		t2.setDaemon(true);
		t2.start();
	}
}
