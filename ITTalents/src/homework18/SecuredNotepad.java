package homework18;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password != null && !password.isEmpty()) {
			this.password = password;
		} else {
			System.out.println("Password cannot be empty");
		}
	}

	public SecuredNotepad(String password) throws InsufficientPasswordStrengthException {
		super();
		if (isPassWordStrongRegex(password)) {
		//if (isPassWordStrong(password)) {
			this.setPassword(password);
		} else {
			throw new InsufficientPasswordStrengthException("Password is not strong enough");
		}
	}

	public boolean isPasswordValid() {
		System.out.println("Enter password:");
		Scanner sc = new Scanner(System.in);
		String pass = sc.nextLine();
		if (pass.equals(getPassword())) {
			System.out.println("Access granted");
			return true;
		}
		return false;
	}

	@Override
	public void addTextToPage(int pageNumber, String newText) {
		if (isPasswordValid()) {
			this.getPages().get(pageNumber - 1).addText(newText);
		} else {
			System.out.println("Invalid password");
		}
	}

	@Override
	public void replaceTextFromPage(int pageNumber, String newText) {
		if (isPasswordValid()) {
			this.getPages().get(pageNumber - 1).replaceText(newText);
		} else {
			System.out.println("Invalid password");
		}
	}

	@Override
	public void deleteTextFromPage(int pageNumber) {
		if (isPasswordValid()) {
			this.getPages().get(pageNumber - 1).deleteText();
		} else {
			System.out.println("Invalid password");
		}
	}
	
	public boolean isPassWordStrong(String password) {
		int lowerCaseLetter = 0;
		int upperCaseLetter = 0;
		int numberOfSymbols = 0;
		int numberOfNumbers = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				lowerCaseLetter++;
			}
			if (Character.isUpperCase(password.charAt(i))) {
				upperCaseLetter++;
			}
			if (Character.isLetter(password.charAt(i))) {
				numberOfSymbols++;
			} else {
				numberOfSymbols++;
			}
			if (Character.isDigit(password.charAt(i))) {
				numberOfNumbers++;
			}
		}
		return (numberOfSymbols >= 5 && lowerCaseLetter >= 1 && upperCaseLetter >= 1 && numberOfNumbers >= 1);
	}
	
	public boolean isPassWordStrongRegex(String password) {
		return password.matches("[{5,[A-Za-z]}0-9]+");
	}
}
