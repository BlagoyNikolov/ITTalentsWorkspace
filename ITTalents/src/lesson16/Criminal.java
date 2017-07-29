package lesson16;

public class Criminal extends Person {

	private int crimes;
	
	protected Criminal(String name, int crimes){
		super(name);
		this.crimes = crimes;
	}
	
	Criminal getPartner(){
		return null;
	}
	
	protected Criminal(String name, int age, int crimes) {
		super(name, age);
		this.crimes = crimes;
	}
	
//	@Override
	public void kill(){
//		super.kill();
		System.out.println(this.name + " shoots you with a gun");
	}
	
	public void goToJail(){
		System.out.println("Damn! Not again ...");
	}
	
	public void commitCrime(){
		System.out.println("Ho-ho-ho");
	}
}

