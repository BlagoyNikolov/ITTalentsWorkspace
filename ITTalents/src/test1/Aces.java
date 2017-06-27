package test1;

import java.util.Random;

public class Aces {
public static void main(String[] args) {
		
		//kak se pada aso? ot 52 karti?
		//kak se pada vtoro ot ostanalite 51 karti?
		// --||-- kato prednata zada4a
		Random r = new Random();
		int sum = 0;
		for (int i = 0; i < 10008; i++) {
			int countAces = 0;
			int countTries = 0;
			while(true){
				int firstDraw = r.nextInt(52) + 1;
				int secondDraw = r.nextInt(51) + 1;
				if((firstDraw == 1 || firstDraw == 2 || firstDraw == 3 || firstDraw == 4) && 
				  (secondDraw == 1 || secondDraw == 2 || secondDraw == 3)){
					countAces++;
					if(countAces == 2){
						break;
					}
				}
				else{
					countAces = 0;
				}
				countTries++;
			}
			sum += countTries;
		}
		System.out.println(sum/10008);
	}
}
