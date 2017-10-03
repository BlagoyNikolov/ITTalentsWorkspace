package test2.documents;

import java.util.Random;

import test2.employees.Employee;
import test2.employees.Senior;

public class SecretDocument extends Document {
	private String password;

	public SecretDocument(String title, String pass) {
		super(title);
		this.password = pass;
	}

	@Override
	public void addEditor(Employee e) {
		if (e instanceof Senior) {
			this.editor = e;
		} else {
			System.out.println("Editor is not senior!");
		}
		
	}

	@Override
	public String toString() {
		return "SecretDocument [title=" + title + ", complexity=" + complexity + ", editor=" + editor + ", status="
				+ status + "]";
	}
	
	@Override
	public int compareTo(Document o) {
		// TODO Auto-generated method stub
		return this.title.compareTo(o.title);
	}
	
	public static String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
}
