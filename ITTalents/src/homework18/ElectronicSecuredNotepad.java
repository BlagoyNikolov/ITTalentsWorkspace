package homework18;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IÅlectronicDevice {
	private boolean isStarted;

	@Override
	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public ElectronicSecuredNotepad(String password) throws InsufficientPasswordStrengthException {
		super(password);
	}

	@Override
	public void start() {
		this.setStarted(true);
	}

	@Override
	public void stop() {
		this.setStarted(false);
	}

	@Override
	public void addTextToPage(int pageNumber, String newText) {
		if (this.isStarted()) {
			if (isPasswordValid() && this.isStarted()) {
				this.getPages().get(pageNumber - 1).addText(newText);
			} else {
				System.out.println("Invalid password");
			}
		} else {
			System.out.println("Device is not started");
		}
	}

	@Override
	public void replaceTextFromPage(int pageNumber, String newText) {
		if (this.isStarted()) {
			if (isPasswordValid()) {
				this.getPages().get(pageNumber - 1).replaceText(newText);
			} else {
				System.out.println("Invalid password");
			}
		} else {
			System.out.println("Device is not started");
		}
	}

	@Override
	public void deleteTextFromPage(int pageNumber) {
		if (this.isStarted()) {
			if (isPasswordValid() && this.isStarted()) {
				this.getPages().get(pageNumber - 1).deleteText();
			} else {
				System.out.println("Invalid password");
			}
		}else {
			System.out.println("Device is not started");
		}
	}
}
