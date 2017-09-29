package rakia;

public class Demo {
	public static void main(String[] args) {
		Bidon bidonq = new Bidon();
		Koop magazinq = new Koop();
		ZaharenZavod zavod = new ZaharenZavod();
		StuklarskiCeh ceh = new StuklarskiCeh();
		Thread berachka1 = new Berachka(bidonq, "Berachka 1");
		Thread berachka2 = new Berachka(bidonq, "Berachka 2");
		Thread rakijiq = new Rakijiq(bidonq, magazinq, zavod, ceh, "Rakijiqta");
		Shkembejiq shkembejiq = new Shkembejiq(magazinq, "Shkembejiqta");
		Thread vietnamec1 = new Vietnamec(zavod, "Vietnamec 1");
		Thread vietnamec2 = new Vietnamec(zavod, "Vietnamec 2");
		Thread shkembejiika = new Shkembejiika(bidonq, magazinq, zavod, ceh, shkembejiq, "Shkembejikata");
		Thread stuklar1 = new Stuklar(ceh, "Stuklar 1");
		Thread stuklar2 = new Stuklar(ceh, "Stuklar 2");
		Thread logger = new Logger(bidonq, magazinq, ceh, zavod);
		
		berachka1.start();
		berachka2.start();
		rakijiq.start();
		shkembejiq.start();
		shkembejiika.start();
		vietnamec1.start();
		vietnamec2.start();
		stuklar1.start();
		stuklar2.start();
		logger.start();
	}
}
