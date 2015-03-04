package gg;

import ggpack.IGuessingGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GuessingGame implements IGuessingGame {

	
	private static  int lower =0;
	private static  int higher=1000;
	Set<Integer> cheatSet = new HashSet<Integer>();
	
	public GuessingGame(int lower, int higher){
		this.lower =lower;
		this.higher =higher;
		
	}
	
	@Override
	public int guess(int lower, int higher) {
		int guessedInt = lower;
		guessedInt = (lower+higher) >>>1;
		
		if (cheatSet.contains(guessedInt)){
			
			System.out.println("The player is cheating, no SOUP FOR YOU");
			System.exit(0);
		}
		
		cheatSet.add(guessedInt);
	return guessedInt;
		
	}

	@Override
	public String initSetup() {
		System.out.println("Type \"ready\"  to start \n, "
				+ "and think about a number between"+ lower +" and  " + higher + " values, type \"lower\" if your number is lower \n than the guessed number and \"higher\" if"
				+ " the number is higher. \nIf the number is correct, enter \"yes\"");
		Scanner in = new Scanner(System.in);
		String isReady = in.next();
		//in.close();
		return isReady;
	}

	@Override
	public int loopThrough(int tries, String response) {
		int printOut;
		Scanner in = new Scanner(System.in);
		for(;;){
			printOut = this.guess(lower,higher);
			System.out.println("Is the number " + printOut +" ?");
			response = in.next();
			if (response.equalsIgnoreCase("yes")) {
				System.out.println("Found in " + tries);
				break;
			}
			if (response.equalsIgnoreCase("higher"))
			{
				lower=printOut+1;
				
			}
			else if(response.equalsIgnoreCase("lower"))
			{
				higher = printOut -1;
			}
			else if(response.equalsIgnoreCase("end"))
			{
				System.out.println("End of game");
				tries = -1;
				break;
			}
			tries++;
		}
		return tries;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				GuessingGame gg = new GuessingGame(0,1000);
				String ready = gg.initSetup();
				
				int tries=1;
				
				String response = new String();
				
				
				if (ready.equalsIgnoreCase("ready"))
						{
							gg.loopThrough(tries, response);
						}		
				

	}

}
