package homework13;

public class GSM {
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	double outgoingCallsDuration;
	Call lastIncomingCall;
	Call lastOutgoingCall;
	
	public void insertSimCard(String simMobileNumber) {
		if (simMobileNumber.startsWith("08") && simMobileNumber.length() == 10) {
			this.simMobileNumber = simMobileNumber;
			this.hasSimCard = true;
		} else {
			System.out.println("Invalid SIM number");
		}
	}
	
	public void removeSimCard() {
		this.hasSimCard = false;
		this.simMobileNumber = null;
	}
	
	public void call(GSM receiver, double duration) {
		//if (duration > 0 && !(receiver.simMobileNumber.equals(this.simMobileNumber)) && receiver.hasSimCard && this.hasSimCard) {
		if (duration > 0) {
			if (!(receiver.simMobileNumber.equals(this.simMobileNumber))) {
				if (receiver.hasSimCard && this.hasSimCard) {
					Call call = new Call();
					call.receiver = receiver;
					call.caller = this;
					call.duration = duration;
					this.lastOutgoingCall = call;
					receiver.lastIncomingCall = call;
					this.outgoingCallsDuration += duration;
				} else {
					System.out.println("One or more phoes do not have a SIM card");
				}
			} else {
				System.out.println("The SIM numbers of the hones are the same");
			}	
		} else {
			System.out.println("Invalid call duration");
		}
	}
	
	public double getSumForCall() {
		return Call.priceForAMinute * this.outgoingCallsDuration;
	}
	
	public void printInfoForTheLastOutgoingCall() {
		if (lastOutgoingCall == null) {
			System.out.println("There are no outgoing calls");
		} else {
			System.out.printf("Last outgoing call: Model: %s, Duration: %.2f\n", model, lastOutgoingCall.duration);
		}
	}
	
	public void printInfoForTheLastIncomingCall() {
		if (lastIncomingCall == null) {
			System.out.println("There are no incoming calls");
		} else {
			System.out.printf("Last incoming call: Model: %s, Duration: %.2f\n", model, lastIncomingCall.duration);
		}
	}
}
