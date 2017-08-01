package homework18;

import java.util.ArrayList;

public class SimpleNotepad implements INotepad {
	private ArrayList<Page> pages;
	
	public ArrayList<Page> getPages() {
		return pages;
	}
	
	public void setPages(ArrayList<Page> pages) {
		if (pages != null) {
			this.pages = pages;
		} else {
			System.out.println("Invalid list of pages");
		}
	}
	
	public SimpleNotepad() {
		this.setPages(new ArrayList<Page>());
	}
	
	public void addPage(Page page) {
		this.getPages().add(page);
	}
	
	@Override
	public void addTextToPage(int pageNumber, String newText) {
		this.getPages().get(pageNumber - 1).addText(newText);
	}

	@Override
	public void replaceTextFromPage(int pageNumber, String newText) {
		this.getPages().get(pageNumber - 1).replaceText(newText);
	}

	@Override
	public void deleteTextFromPage(int pageNumber) {
		this.getPages().get(pageNumber - 1).deleteText();
	}

	@Override
	public void viewAllPages() {
		for (Page page : this.getPages()) {
			System.out.println(page.viewPage());
		}
	}

	@Override
	public boolean searchWord(int pageNumber, String word) {
		return this.getPages().get(pageNumber - 1).searchWord(word);
	}

	@Override
	public void printAllPagesWithDigits() {
		for (Page page : this.getPages()) {
			if (page.containsDigits()) {
				System.out.println("Page with digits \n" + page.viewPage());
			}
		}
	}
}
