package service;

import java.util.Random;

public class NormalDiceService implements DiceService {
	
	@Override
	public  int roll() {
		
		return new Random().nextInt(6)+1;
		
	}

}
