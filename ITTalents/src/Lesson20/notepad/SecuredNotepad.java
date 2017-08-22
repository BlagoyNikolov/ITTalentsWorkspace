package Lesson20.notepad;

import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

public class SecuredNotepad extends SimpleNotepad{

	private String password;
	private Scanner sc = new Scanner(System.in);
	
	public SecuredNotepad(int pages, String password) {
		super(pages);
		if(isStrongPass(password)){
			this.password = password;
		}
		else{
			try {
				throw new InvalidAttributeValueException();
			} catch (InvalidAttributeValueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean isStrongPass(String pass){
		if(pass.length() < 5){
			return false;
		}
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean hasDigit = false;
		
		for (int i = 0; i < pass.length(); i++) {
			char c = pass.charAt(i);
			if(Character.isDigit(c)){
				hasDigit = true;
			}
			if(Character.isUpperCase(c)){
				hasUpper = true;
			}
			if(Character.isLowerCase(c)){
				hasLower = true;
			}
		}
		return hasUpper && hasLower && hasDigit;
	}
	
	private boolean validPass(){
		System.out.println("Enter the password!");
		if(sc.nextLine().equals(this.password)){
			return true;
		}
		else{
			System.out.println("Begi ottuka!");
			return false;
		}
	}
	
	@Override
	public void addText(int pageNumber, String txt) {
		if(validPass()){
			super.addText(pageNumber, txt);
		}
	}
	
	@Override
	public void deleteText(Page p) {
		if(validPass()){
			super.deleteText(p);
		}
	}
	
	@Override
	public void replaceText(int pageNumber, String txt) {
		if(validPass()){
			super.replaceText(pageNumber, txt);
		}
	}
	
	@Override
	public void showPages() {
		if(validPass()){
			super.showPages();
		}
	}

}
