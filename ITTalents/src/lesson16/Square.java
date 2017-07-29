package lesson16;

public class Square {

	public static void main(String[] args) {
		
		King abdula = new King("Abdula 4ti");
		abdula.name = "4";
		Criminal pesho = new Criminal("Pesho", 43, 3);
		System.out.println("-----------------");
//		Mutra kompir = new Mutra();
		System.out.println("-----------------");
		
		abdula.eat();
		pesho.eat();
		
	}
}
