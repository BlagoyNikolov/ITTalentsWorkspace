package threads.bob;

public class Vnuche extends Thread {

	private Gurne gurne;
	
	Vnuche(Gurne gurne){
		this.gurne = gurne;
	}
	
	@Override
	public void run() {
		while(true){
			gurne.hapniBob();
		}
	}
}