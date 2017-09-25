package threads.bob;

public class Baba extends Thread {

	private Gurne gurne;
	
	Baba(Gurne gurne){
		this.gurne = gurne;
	}
	
	@Override
	public void run() {
		while(true){
			gurne.sipiBob();
		}
	}
}
