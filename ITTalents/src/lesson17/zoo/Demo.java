package lesson17.zoo;

public class Demo {

	public static void main(String[] args) {
	
		Zoo zoo = new Zoo();
		
		Goat cecka = new Goat("Cvetana");
		Sheep doli = new Sheep("Dorita");
		
		zoo.addAnimal(cecka);
		zoo.addAnimal(doli);
		zoo.addAnimal(new Chicken("penka"));
		
		zoo.feedThemAll();
		zoo.makeEclipseHappen();
		
	}
	
}
