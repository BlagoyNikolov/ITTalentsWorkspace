package lesson08;

public class Greetings {

	public static void main(String[] args) {
		
		greet("Poli2D");
		greet("KristiyanT1000");
		greet("VesiT1010");
		greet("R2D2");
	}
	
	
	static boolean isRobot(String name){
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i) >= '0' && name.charAt(i) <= '9'){
				return true;
			}
		}
		return false;
	}
	
	static void greet(String name){
		if(isRobot(name)){
			System.out.println("Ooo, " + name + "! Ai chao!");
		}
		else{
			System.out.println("Greetings, " + name +"! How are you?");
		}
	}
}
