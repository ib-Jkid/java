package main;

import investment.Assets;
import work.Jobs;

public class Man extends Listener{
	public static enum Workplace {BANK,LIBRARY};
	public static Workplace workplace;
	public static boolean employed = false;
	public static Double dollarAtHand = 0.0;
	public static Double nairaAtHand = 0.0;
	public static Double poundAtHand = 0.0;
	public static boolean gameOver = false; 

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Thread vitual = new Thread(new Runnable() {

			@Override
			public void run() {
				action();
				
			}
			
		});
		Thread interval = new Thread(new Runnable() {

			@Override
			public void run() {
				interval();
				
			}
			
		});
		interval.start();
		vitual.start();
		while(!gameOver) {
			
		}
		
		if(gameOver) {
			interval.stop();
			vitual.stop();
			System.out.println("gameEnded");
		}

	}
	public static void action () {
		boolean exit = false;
		while(!exit) {
			System.out.printf("Welcome!!!\n"
					+ "1: Start New Game\n"
					+ "2: Continue From Last Saved\n"
					+ "3: Exit Game\n");
			int response = getResponse(0);
			
			if(response == 1) {
				startNewGame();
			}else if(response == 2) {
				System.out.println("not implementded yet");
			}else {
				gameOver = true;
				exit = true;
			}
		}
		
	}
	private static void startNewGame() {
		Assets asset = new Assets();
		Money money = new Money();
		boolean exit = false;
		while(!exit) {
			System.out.printf("What do you want to do\n"
					+ "1: Goto Bank\n"
					+ "2: Manage Assets\n"
					+ "3: Get A job\n"
					+ "4: Money at Hand\n");
			int response = getResponse(0);
			switch (response) {
				case 1:
					Money.banking(money);
					break;
				case 2:
					Assets.startTrading(asset);
					break;
				case 3:
					Jobs.menu();
					break;
				case 4:
					System.out.printf("Dollar at hand = $%s\n"
							+ "Naira at hand = N%s\n"
							+ "Pound at hand = E%s\n",Man.dollarAtHand,Man.nairaAtHand,Man.poundAtHand);
					break;
				default: 
					System.out.println("Not Implemented");
					break;
			}
		}
		
		
	}
	public static void interval () {
		Timer.timeLoop();
	}
	

}
