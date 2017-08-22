package Lesson20.notepad;

public class Page {

	private String title;
	private String text;
	
	public Page(String title) {
		this.title = title;
		this.text = "";
	}
	
	void addText(String text){
		if(text != null){
			this.text = this.text.concat(text);
		}
	}
	
	void deleteText(){
		this.text = "";
	}
	
	String showInfo(){
		return title + " - " + text;
	}
	
	
}
