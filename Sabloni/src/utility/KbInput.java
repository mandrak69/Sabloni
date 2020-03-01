package utility;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class KbInput {
private static Scanner sc;
	private  KbInput() {
		// Singletonclass for keyboard input
			Scanner sc=new Scanner(System.in);
			this.sc=sc;
			
		
	}
	/**
	 * @return the sc
	 */
	public static Scanner getScanner() {
		if (sc==null){
			new KbInput();
		}
		return sc;
	}
	/*
	 *  right way to get random
	 */
	
	public static int getRandom(int number) {
		return ThreadLocalRandom.current().nextInt(0, number + 1);
	}

}
