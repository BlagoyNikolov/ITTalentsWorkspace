package homework18;

public interface ISecuredNotepad {
	public void addPage(Page page);
	public void addTextToPage(int pageNumber, String newtext);
	public void replaceTextFromPage(int pageNumber, String newtext);
	public void deleteTextFromPage(int pageNumber);
	public void viewAllPages();
	public boolean isPasswordValid();
}
