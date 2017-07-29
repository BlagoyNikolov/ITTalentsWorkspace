package lesson15.examples;

import lesson15.ovci.Ovca;

public class Demo {

	public static void main(String[] args) {
		
		final Person thaicho = new Person('m');
		thaicho.setName("Trayan");
		
		Ovca[] stado = new Ovca[5];
		stado[0] = new Ovca("Minka", 31);
		stado[1] = new Ovca("Ginka", 21);
		stado[2] = new Ovca("Dinka", 13);
		stado[3] = new Ovca("Kinka", 41);
		stado[4] = new Ovca("Finka", 8);
		
		Ovca.ovchar = thaicho;
		stado[0].ovchar = new Person('f');
		System.out.println(stado[4].ovchar.getName());
	}
}
