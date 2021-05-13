package service;

import java.util.Optional;

import model.*;

public class InitializeGame {
	
	
	private Board snakeAndLadderBoard;
	
	private Boolean gameCompletedFlag;
	
	private Player player;
	
	private static final int DEFAULT_BOARD_SIZE = 100;
	
	private static final int DEFAULT_TURNS = 10;
	
	private DiceService diceService;

	public InitializeGame() {
		
		this.snakeAndLadderBoard = new Board(DEFAULT_BOARD_SIZE);
		
	}
	
	
	

	public Boolean getGameCompletedFlag() {
		return gameCompletedFlag;
	}




	public void setGameCompletedFlag(Boolean gameCompletedFlag) {
		this.gameCompletedFlag = gameCompletedFlag;
	}




	public static int getDefaultTurns() {
		return DEFAULT_TURNS;
	}




	public Board getSnakeAndLadderBoard() {
		return snakeAndLadderBoard;
	}

	public void setSnakeAndLadderBoard(Board snakeAndLadderBoard) {
		this.snakeAndLadderBoard = snakeAndLadderBoard;
	}


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static int getDefaultBoardSize() {
		return DEFAULT_BOARD_SIZE;
	}
	
	
	public DiceService getDiceService() {
		return diceService;
	}

	public void setDiceService(DiceService diceService) {
		this.diceService = diceService;
	}

	private int getNewPostionAfterUsingSnakesAndLadders(int position) {
		
		while(true ) {
			
			int tempPos = position;
			
			Optional<Snake> snake = snakeAndLadderBoard.getSnakes().stream().filter(s -> s.getStart()== tempPos).findFirst();
			
			
			Optional<Ladder> ladder = snakeAndLadderBoard.getLadders().stream().filter(l -> l.getStart()== tempPos).findFirst();
			
			if(snake.isEmpty() && ladder.isEmpty()) return position;
			
			if(snake.isPresent()) {
				
				position = snake.get().getEnd(); 
				
				System.out.println("After biting by snake at "+snake.get().getStart()+" new position is = "+position);
			}
			
			if(ladder.isPresent()) {
				
				
				position = ladder.get().getEnd();
				
				System.out.println("After using ladder at "+ladder.get().getStart()+" new position is = "+position);
				
			}
			
			
			
			
			if(tempPos == position) break;
		
		}
		
		return position;
	}
	
	private void  positionByRollingDice(int pos) {
		
		
		int diceVal = this.diceService.roll();
		
		int newpos = pos+diceVal;
		
		if(newpos > DEFAULT_BOARD_SIZE) {
			
			 newpos = pos;
		}
		
		this.getPlayer().setTurnNumber(this.getPlayer().getTurnNumber()+1);
		
		System.out.println(" Player =  "+this.player.getName()+"  turn no = "+this.player.getTurnNumber()+" rolled a "+diceVal+" and moved from "+pos+" to "+newpos);
		
		newpos = getNewPostionAfterUsingSnakesAndLadders(newpos);
		
		this.snakeAndLadderBoard.getPlayesrLocation().put(this.player.getName(), newpos);
	}
	
	private boolean PlayerWins(Player player) {
		
		
		int pos = this.snakeAndLadderBoard.getPlayesrLocation().get(player.getName());
		
		if(pos == DEFAULT_BOARD_SIZE) return true;
		
		return false;
	}
	
	private boolean isGameCompleted() {
		
		return PlayerWins(this.player) || this.player.getTurnNumber()>=DEFAULT_TURNS;
		
	}
	
	
	public void startGame() {
		
		int startPos = 0;
		
		while(!isGameCompleted()) {
			
			positionByRollingDice(startPos);
			
			if (PlayerWins(this.player)) {
				
				System.out.println("Congratulations !! "+this.player.getName()+"  won the match");
			}
			
			startPos = this.snakeAndLadderBoard.getPlayesrLocation().get(this.player.getName());
		}
		
		this.gameCompletedFlag = true;
		
		System.out.println("Game Over");
	}
	

}
