package startup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;
import service.*;

public class Init {
	
	
	public static void main(String ar[]) {
		
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Please Enter Number of Snakes");
		 
		 int nos = scanner.nextInt();
		 
		 List<Snake> snakes = new ArrayList<Snake>();
		 
		 System.out.println("Enter "+nos+" lines each containing 2 numbers denoting the head and tail positions of the snake.");
		 
		 while(nos-->0) {
			 
			 int start = scanner.nextInt();
			 
			 int end = scanner.nextInt();
			 
			 if(start <= end || start <1 || start >100 || end < 1 || end >100 ) {
				 
				 System.out.println("Invalid start and end point of snake. Please enter again"); nos++; continue;
				 
			 }
			 
			 snakes.add(new Snake(start,end));
		 }
		 
		 System.out.println("Please Enter Number of Ladders");
		 
		 List<Ladder> ladders = new ArrayList<Ladder>();
		 
		 int nol = scanner.nextInt();
		 
		 System.out.println("Enter "+nol+" lines each containing 2 numbers denoting the start and end positions of the ladder.");
		 
		 while(nol-->0) {
		 
			 int start = scanner.nextInt();
			 
			 int end = scanner.nextInt();
			 
			if(start >= end || start <1 || start >100 || end < 1 || end >100) {
				 
				 System.out.println("Invalid start and end point of ladder. Please enter again"); nol++; continue;
			 }
			 
			 else if(snakes.stream().filter(s -> s.getStart() == start).findAny().isPresent()) {
				 
				 System.out.println("Invalid start point of ladder. Snake and Ladder cannot start from same postion . Please enter again"); nol++; continue;
				 
			 }
			 else if(snakes.stream().filter(s -> (s.getStart() == end && s.getEnd()==start)).findAny().isPresent()) {
				 
				 System.out.println("Invalid start point of ladder. loop is detected. please try enter again "); nol++; continue;
				 
			 }
			 
			 ladders.add(new Ladder(start,end));
		 }
		 
		 
		 System.out.println("Press 1 for normal Dice and Press 2 for crooked Dice");
		 
		 int diceType = scanner.nextInt();
		 
		 /// initialize Player 
		 
		 System.out.println("Enter Player Name");
		 
		 String name = scanner.next();
		 
		 Player player = new Player(name);
		 
		 player.setTurnNumber(0);
		 
		 //initialize Board
		
		 InitializeGame game = new InitializeGame();
		 
		 game.setPlayer(player);
		 
		 game.getSnakeAndLadderBoard().setSnakes(snakes);
		 
		 game.getSnakeAndLadderBoard().setLadders(ladders);
		 
		 game.getSnakeAndLadderBoard().getPlayesrLocation().put(name, 0);
		
		 game.setDiceService(diceType==1 ? new NormalDiceService() : new CrookedDiceService());
		 
		 System.out.println("########################### Game Starts ######################");
		 
	
		 game.startGame();
		 
	}

}
