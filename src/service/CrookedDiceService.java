package service;

import java.util.Random;

public class CrookedDiceService implements DiceService {
	

	int[] evenNo = new int[] {5,5,5};
	
	@Override
	public int roll() {
		
		return evenNo[ new Random().nextInt(3)];
		
	}

}
