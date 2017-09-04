package recap;

public class Child extends Parent {
	public Child() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Speak(String word) {
		// TODO Auto-generated method stub
		super.Speak(word);
	}
	
	public void Speak(String word, int itmes) {
		int x = 5;
		System.out.println(x);
	}
	
//	@Override
//	public void Speak(String word, int itmes) {
//		int y = 5;
//		System.out.println(y);
//	}
}
