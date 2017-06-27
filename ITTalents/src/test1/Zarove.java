package test1;

import java.util.Random;

public class Zarove {
public static void main(String[] args) {
		int countTries = 0;
		int counterSevens = 0;
		while(true){
			//kak da hvurlq zar?
			Random r = new Random();
			int zar1 = r.nextInt(6) + 1;//0 - 5
			int zar2 = r.nextInt(6) + 1;//0 - 5
			//kak da proverq dali 2 zara sa = 7
			if(zar1 + zar2 == 7){
				counterSevens++;
				if(counterSevens == 7){
					break;
				}
			}
			else{
				counterSevens = 0;
			}
			countTries++;
		}
		System.out.println(countTries);
	}
}
