package test1;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] map =  {
							{' ', '|',' ', '|',' '},
							{'-', '-','-', '-','-'},
							{' ', '|',' ', '|',' '},
							{'-', '-','-', '-','-'},
							{' ', '|',' ', '|',' '},
						};
		
		System.out.println("Welcome to our game!");
		
		System.out.println("This is the map (imagine it)");
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("players can choose between X and O for drawing");
		System.out.println("Please choose!");
		char symbol = sc.nextLine().charAt(0);
		while(symbol != 'X' && symbol != 'O'){
			System.out.println("Incorrect symbol, try again!");
			symbol = sc.nextLine().charAt(0);
		}
		char enemySymbol = symbol == 'X' ? 'O' : 'X';
		
		while(true){//play
			System.out.println("Choose coordinates");
			int row = sc.nextInt();
			int col = sc.nextInt();
			int realRow = row;
			//check for row
			while(row < 0 || row > 3){
				System.out.println("Invalid coordinates for row, try again");
				row = sc.nextInt();
			}
			if(row == 1){
				realRow = 0;
			}
			else
			if(row == 3){
				realRow = 4;
			}
			//now for column
			int realCol = col;
			while(col < 0 || col > 3){
				System.out.println("Invalid coordinates for col, try again");
				col = sc.nextInt();
			}
			if(col == 1){
				realCol = 0;
			}
			else
			if(col == 3){
				realCol = 4;
			}
			if(map[realRow][realCol] != ' '){
				System.out.println("The field is already taken, choose other coordinates");
				continue;
			}
			
			System.out.println("coordinates received!");
			
			map[realRow][realCol] = symbol;
			
			//check for victory
			
			//until coordinates are free, enter random coords and put enemy symbol in it
			Random r = new Random();
			int enemyRealRow;
			int enemyRealCol;
			while(true){
				enemyRealRow = r.nextInt(3)*2;//0, 2 or 4
				enemyRealCol = r.nextInt(3)*2;//0, 2 or 4
				if(map[enemyRealRow][enemyRealCol] == ' '){
					break;
				}
			}
			map[enemyRealRow][enemyRealCol] = enemySymbol;
			
			//check for victory
			
			//print the map again:
			System.out.println("This is the map (imagine it)");
			for(int i = 0; i < map.length; i++){
				for(int j = 0; j < map[i].length; j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
