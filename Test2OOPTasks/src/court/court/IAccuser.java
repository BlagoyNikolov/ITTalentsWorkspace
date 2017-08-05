package court.court;

import java.util.ArrayList;
import java.util.Random;

public interface IAccuser {
	public ArrayList<String> questions = new ArrayList<String>();
	
	static String getRandomQuestion() {
		return questions.get(new Random().nextInt(questions.size()));
	}
	public void askQuestion();
}
