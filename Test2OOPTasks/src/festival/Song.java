package festival;

public class Song {
	private String title;
	private String text;
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	
	public Song(String title, String text) {
		this.title = title;
		this.text = text;
	}
		
	@Override
	public String toString() {
		return "Song [title=" + title + ", text=" + text + "]";
	}
}
