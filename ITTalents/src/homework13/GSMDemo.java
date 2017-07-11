package homework13;

public class GSMDemo {
	public static void main(String[] args) {
		GSM pixel = new GSM();
		pixel.model = "Google Pixel";
		pixel.insertSimCard("0889456123");

		GSM op3t = new GSM();
		op3t.model = "OnePlus 3T";
		op3t.insertSimCard("0888720060");

		//pixel.call(pixel, 2);
		pixel.call(op3t, 4.5);
		op3t.call(pixel, 8);

		System.out.println("Sum of all calls " + pixel.getSumForCall());
		pixel.printInfoForTheLastIncomingCall();
		pixel.printInfoForTheLastOutgoingCall();
		
		System.out.println("Sum of all calls " + op3t.getSumForCall());
		op3t.printInfoForTheLastIncomingCall();
		op3t.printInfoForTheLastOutgoingCall();
		
		pixel.call(op3t, 2.5);
		op3t.call(pixel, 4);
		
		System.out.println("Sum of all calls " + pixel.getSumForCall());
		pixel.printInfoForTheLastIncomingCall();
		pixel.printInfoForTheLastOutgoingCall();
		
		System.out.println("Sum of all calls " + op3t.getSumForCall());
		op3t.printInfoForTheLastIncomingCall();
		op3t.printInfoForTheLastOutgoingCall();
	}
}
