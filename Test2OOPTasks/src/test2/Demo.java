package test2;

import java.util.ArrayList;
import java.util.Random;

import test2.company.Company;
import test2.documents.Document;
import test2.documents.OrdinaryDocument;
import test2.documents.SecretDocument;

public class Demo {
	public static void main(String[] args) {
		//1 create office
		Company company = new Company("IT Talents ftw");
		
		//2 add employees
		
		//3 generate 50 documents
		ArrayList<Document> fiftyDocs = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			int x = new Random().nextInt(2);
			switch (x) {
			case 0:
				fiftyDocs.add(new OrdinaryDocument("Doc"+1));
				break;
			case 1:
				fiftyDocs.add(new SecretDocument("Doc"+1, SecretDocument.getRandomString()));
				break;
			default:
				break;
			}
		}
		for (Document document : fiftyDocs) {
			company.processDocument(document);
		}
		
		//4 generate 10 documents
		ArrayList<Document> tenDocs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int x = new Random().nextInt(2);
			switch (x) {
			case 0:
				tenDocs.add(new OrdinaryDocument("Doc"+1));
				break;
			case 1:
				tenDocs.add(new SecretDocument("Doc"+1, SecretDocument.getRandomString()));
				break;
			default:
				break;
			}
		}
		for (Document document : fiftyDocs) {
			company.processDocument(document);
			
		}
		
		//5 print random emp stats
		company.getRandomEmployee().printAll();
		company.getRandomEmployee().printAll();
		company.getRandomEmployee().printAll();
		company.getRandomEmployee().printAll();
		company.getRandomEmployee().printAll();
		
		//6 random fire smotan
		
		
		//7 print all office stats
		company.printCompanyAll();
		
	}
}
