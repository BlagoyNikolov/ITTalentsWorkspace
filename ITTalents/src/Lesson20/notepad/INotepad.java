package Lesson20.notepad;

public interface INotepad {

	void addText(int pageNumber, String txt);
	void replaceText(int pageNumber, String txt);
	void deleteText(Page p);
	void showPages();
	
}
