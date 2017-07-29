package lesson16;

public class King extends Person{

	private int jeniVHarema;
	
	public King(String name){
		super(name);
		this.jeniVHarema = 100;
		System.out.println("A king was born");
	}
	
	public void kill(){
//		super.kill();
		System.out.println(this.name + " bashes you with a scepter");
	}
	
	public void goNaughty(){
		this.jeniVHarema--;
		//yo ho ho
		this.jeniVHarema++;
	}
}
