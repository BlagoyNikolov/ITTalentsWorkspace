package Lesson20.notepad;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice{

	private boolean isStarted;
	
	public ElectronicSecuredNotepad(int pages, String password) {
		super(pages, password);
		this.isStarted = false;
	}
	
	@Override
	public void addText(int pageNumber, String txt) {
		if(isStarted){
			super.addText(pageNumber, txt);
		}
	}
	
	@Override
	public void deleteText(Page p) {
		if(isStarted){
			super.deleteText(p);
		}
	}
	
	@Override
	public void replaceText(int pageNumber, String txt) {
		if(isStarted){
			super.replaceText(pageNumber, txt);
		}
	}
	
	@Override
	public void showPages() {
		if(this.isStarted){
			super.showPages();
		}
	}

	@Override
	public void start() {
		if(!isStarted){
			isStarted = true;
		}
	}

	@Override
	public void stop() {
		if(isStarted){
			isStarted = false;
		}
	}

	@Override
	public boolean isStarted() {
		return this.isStarted;
	}
	
	

}
