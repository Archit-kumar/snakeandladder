package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import model.*;
import service.CrookedDiceService;
import service.DiceService;
import service.InitializeGame;
import service.NormalDiceService;

@TestInstance(value = Lifecycle.PER_CLASS)
class SnakeeAndLadderTestCase {

	
	private final 	InitializeGame game = new InitializeGame();
	
	private   DiceService normalDice ;
	
	private  DiceService crookedDiceService ;
	
	private Player player;
	
	@BeforeAll
	void init() {
			
		normalDice = new NormalDiceService();;
			
		crookedDiceService = new CrookedDiceService();
		
		player = new Player("TestPlayer");
		
	}
	
	@Test
	void whenTestingForEquality_ShouldBeEqual() {
	
		 
		 List<Snake> snakes = Arrays.asList(new Snake(22, 1,false),
				 new Snake(25,2,false),
				 new Snake(44,5,false),
				 new Snake(33,5,false),
				 new Snake(99,10,false));
		 
		 
		 List<Ladder> ladders = Arrays.asList(new Ladder(22, 1),
				 new Ladder(3,26),
				 new Ladder(6,45),
				 new Ladder(7,50),
				 new Ladder(11,33));
		  
		
		 game.getSnakeAndLadderBoard().setSnakes(snakes);
		 
		 game.getSnakeAndLadderBoard().setLadders(ladders);
		 
		 assertEquals(snakes, game.getSnakeAndLadderBoard().getSnakes());
		 
		 assertEquals(ladders, game.getSnakeAndLadderBoard().getLadders());
	}
	
	@Test
	void whenTestingOnCrookedDice() {
	
		// crooked dice should generate even numbers and less than 6
	
		for(int i =0;i<100; i++) {
			
			int val = crookedDiceService.roll();
			assertTrue(val>=1 && val <=6);
			assertEquals(0, val%2 );
		}
	
	}
	
	@Test
	void whenTestingOnNormalDice() {
	
		for(int i =0;i<100; i++) {
			
			int val = normalDice.roll();
			assertTrue(val>=1 && val <=6);

		}
	
	}
	
	@Test
	void whenTestingOn_Game_should_complete_And_Player_should_not_have_more_than_10_turns() {
	
		 game.setPlayer(player);
		 
		 game.getSnakeAndLadderBoard().setSnakes(new ArrayList<>());
		 
		 game.getSnakeAndLadderBoard().setLadders(new ArrayList<>());
		 
		 game.getSnakeAndLadderBoard().getPlayesrLocation().put(player.getName(), 0);
		 
		 game.setDiceService(new NormalDiceService());
		 
		 game.startGame();
		 
		 assertEquals(true, game.getGameCompletedFlag());
		 
		 assertEquals(true, game.getPlayer().getTurnNumber()<=10);
	
	}
	
	
	// normal Execution flow where from 1 to 6 , at every position there is a ladder to 100. here no of turns taken by player should be 1 
	@Test
	void whenTestingOn_turns() {
	
		 game.setPlayer(player);
		 
		 game.getSnakeAndLadderBoard().setSnakes(new ArrayList<>());
		 
		 List<Ladder> ladders = new ArrayList<>();
		 
		 ladders.add(new Ladder(1,100));
		 ladders.add(new Ladder(2,100));
		 ladders.add(new Ladder(3,100));
		 ladders.add(new Ladder(4,100));
		 ladders.add(new Ladder(5,100));
		 ladders.add(new Ladder(6,100));
		 
		 game.getSnakeAndLadderBoard().setLadders(ladders);
		 
		 game.getSnakeAndLadderBoard().getPlayesrLocation().put(player.getName(), 0);
		 
		 game.setDiceService(new NormalDiceService());
		 
		 game.startGame();
		 
		 assertEquals(true, game.getGameCompletedFlag());
		 
		 assertEquals(true, game.getPlayer().getTurnNumber()==1);
	
	}
	
	
	
	
	
	 @AfterEach
	 void afterEach() {
	       
		 game.setSnakeAndLadderBoard(new Board(InitializeGame.getDefaultBoardSize()));
	 }

}
