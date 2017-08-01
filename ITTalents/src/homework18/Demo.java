package homework18;

public class Demo {
	public static void main(String[] args) throws InsufficientPasswordStrengthException {
		//simpleNotepadDemo();
		//securedNotepadDemo();
		electronicSecuredNotepadDemo();
		
	}

	private static void securedNotepadDemo() throws InsufficientPasswordStrengthException {
		ISecuredNotepad snp = new SecuredNotepad("passw0RD");
		for (int i = 1; i <= 10; i++) {
			snp.addPage(new Page("Page " + i, "here lies the text in page " + i));
		}
		snp.viewAllPages();
		snp.addTextToPage(5, "heres the new text in page 5 pls");
		snp.deleteTextFromPage(6);
		snp.replaceTextFromPage(4, "heres the al new text in page 4 after the old one was replaced");
		System.out.println("--------");
		snp.viewAllPages();
	}

	private static void simpleNotepadDemo() {
		SimpleNotepad sn = new SimpleNotepad();
		for (int i = 1; i <= 10; i++) {
			sn.addPage(new Page("Page " + i, "here lies the text in page " + i));
		}
		sn.viewAllPages();
		sn.addTextToPage(5, "heres the new text in page 5 pls");
		sn.deleteTextFromPage(6);
		sn.replaceTextFromPage(4, "heres the al new text in page 4 after the old one was replaced");
		System.out.println("--------");
		sn.viewAllPages();
	}
	
	private static void electronicSecuredNotepadDemo() throws InsufficientPasswordStrengthException {
		ElectronicSecuredNotepad esn = new ElectronicSecuredNotepad("*passW0RD");
		for (int i = 1; i <= 10; i++) {
			esn.addPage(new Page("Page " + i, "here lies the text in page " + i + " of the electronicSecuredNotepad"));
		}
		esn.viewAllPages();
		esn.start();
		esn.addTextToPage(5, "heres the new text in page 5 of the electronicSecuredNotepad");
		esn.deleteTextFromPage(6);
		esn.replaceTextFromPage(4, "heres the all new text in page 4 after the old one was replaced");
		System.out.println("--------");
		esn.viewAllPages();
	}
}
