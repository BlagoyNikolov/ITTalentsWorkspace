package homework18;

public class Page {
	private String title;
	private String text;
	private static int pageNumber = 1;
	private int currentPageNumber;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
		} else {
			System.out.println("Invalid title");
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		if (text != null && !text.isEmpty()) {
			this.text = text;
		} else {
			System.out.println("Invalid text");
		}
	}
	
	public Page(String title) {
		this.setTitle(title);
		this.currentPageNumber = pageNumber;
		pageNumber++;
	}
	
	public Page(String title, String text) {
		this(title);
		this.setText(text);
	}
	
	public boolean searchWord(String word) {
		return this.getText().contains(word);
	}
	
	public boolean containsDigits() {
		return this.getText().matches("[0-9]");
	}
	
	public void addText(String newText) {
		this.setText(this.getText() + " " + newText);
	}
	
	public void replaceText(String newText) {
		this.setText(newText);
	}
	
	public void deleteText() {
		this.setText(" ");
	}
	
	public String viewPage() {
		return this.getTitle() + "\n" + this.getText();
//		System.out.println(this.getTitle());
//		System.out.println(this.getText());
	}
}
