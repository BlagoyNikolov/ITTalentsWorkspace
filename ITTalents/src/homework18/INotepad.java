package homework18;

public interface INotepad {
	public void addTextToPage(int pageNumber, String newtext);
	public void replaceTextFromPage(int pageNumber, String newtext);
	public void deleteTextFromPage(int pageNumber);
	public void viewAllPages();
	public boolean searchWord(int pageNumber, String word);
	public void printAllPagesWithDigits();
}
