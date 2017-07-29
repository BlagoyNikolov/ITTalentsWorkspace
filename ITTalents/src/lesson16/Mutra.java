package lesson16;

public class Mutra extends Criminal{

	public Mutra(String name, int age, int crimes) {
		super(name, age, crimes);
	}
	
	@Override
	public Mutra getPartner() {
		return null;
	}
	
	public void kill() {
		super.kill();
		super.kill();
		System.out.println(" and then stab you just 134 times with a knife to be sure");
	}

}
