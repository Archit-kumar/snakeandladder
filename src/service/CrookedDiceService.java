package service;

import java.util.Random;

public class CrookedDiceService {
	

	static int[] evenNo = new int[] {2,4,6};
	
	public static int roll() {
		
		return evenNo[ new Random().nextInt(3)];
		
	}

}
