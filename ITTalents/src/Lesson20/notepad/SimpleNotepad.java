package Lesson20.notepad;

import java.util.ArrayList;

public class SimpleNotepad implements INotepad{

	private ArrayList<Page> pages;
	
	public SimpleNotepad(int pages) {
		this.pages = new ArrayList<Page>();
		if(pages > 0){
			for (int i = 0; i < pages; i++) {
				Page p = new Page("Page " + (i+1));
				this.pages.add(p);
			}
		}
	}
	
	private boolean validPageNumber(int pageNumber){
		return pageNumber > 0 && pageNumber < this.pages.size();
	}

	@Override
	public void addText(int pageNumber, String txt) {
		if(validPageNumber(pageNumber)){
			this.pages.get(pageNumber).addText(txt);
		}
	}

	@Override
	public void replaceText(int pageNumber, String txt) {
		if(validPageNumber(pageNumber)){
			Page p = this.pages.get(pageNumber);
			p.deleteText();
			p.addText(txt);
		}
	}

	@Override
	public void deleteText(Page p) {
		if(this.pages.contains(p)){
			p.deleteText();
		}
	}

	@Override
	public void showPages() {
		for(int i = 0; i < this.pages.size(); i++){
			System.out.println(this.pages.get(i).showInfo());
		}
	}
}
