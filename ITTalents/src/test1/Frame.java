package test1;

public class Frame {
public static void main(String[] args) {
		
		String sentence = "Pishete poveche kod!";
		printFrame(sentence);
		
	}
	
	static void printFrame(String sentence){
		//take all words 
		String[] words = sentence.split(" ");
		//find the longest
		int max = words[0].length();
		for(int i = 1; i < words.length; i++){
			if(max < words[i].length()){
				max = words[i].length();
			}
		}
		//draw * = longest+2
		for (int i = 0; i < max+2; i++) {
			System.out.print("*");
		}
		System.out.println();
		//for each word:
			//draw *,word, spaces,*
		for (int i = 0; i < words.length; i++) {
			System.out.print("*");
			System.out.print(words[i]);
			//spaces = max - currentWord.length
			for (int j = 0; j < max - words[i].length(); j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
		//draw * = longest+2
		for (int i = 0; i < max+2; i++) {
			System.out.print("*");
		}
	}
}
