package krasi;

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		String s = "string";
		
		//Optional<String> myOptional = Optional.ofNullable(computer.getSoundcard().getUsb().getVersion());
		Optional<String> myOptional = Optional.ofNullable(s);
		
		boolean isPresent = myOptional.isPresent();
		
		if (isPresent) {
			String version = myOptional.get();
			myOptional.ifPresent(System.out::println);
			//System.out.println("Value is " + version);
		} else {
			System.out.println(myOptional.orElse("No value"));
		}
		
		//Optional.ofNullable(computer.getSoundcard().getUsb().getVersion()).ifPresent(System.out::println);
		Optional.ofNullable(s).ifPresent(System.out::println);
	}
}
