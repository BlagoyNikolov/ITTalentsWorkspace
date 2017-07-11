package lesson13;

public class Demo {

	public static void main(String[] args) {
		
		int x = 5;
		String text = new String("Hello");
		BurkanSLutenica burkan1 = new BurkanSLutenica();//edin burkan
		burkan1.brand = "Todorka";
		burkan1.spiciness = 10;
		BurkanSLutenica burkan2 = new BurkanSLutenica();//edin burkan
		burkan2.brand = "Petel";
		burkan2.volume = 3;
		
		System.out.println(burkan2.volume);
		
		Car ford = new Car();
		ford.model = "Fiesta";
		Car audi = new Car();
		audi.model = "A4";

		Person viki = new Person();
		viki.name = "Victoria";
		viki.age = 18;
		
		viki.growUp();
		System.out.println(viki.age);
		
		ford.owner = viki;
		
		Person iliya = new Person();
		iliya.name = "Iliya";
		iliya.friend = viki;
		viki.friend = iliya;
		
		viki.eat();
		iliya.eat();
		
		iliya.friend = iliya;
		
		System.out.println(iliya.friend.friend.friend.name);
				
		
	}
}
