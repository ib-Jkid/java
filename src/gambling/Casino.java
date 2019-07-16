package gambling;

import main.Listener;

public class Casino extends Listener {
	public static void home() {
		System.out.printf("Welcome to the Casino \n"
				+ "Lost of money to be won if you have the balls \n"
				+ "1: Play the Dice \n"
				+ "6: Exit\n");
		int response = getResponse(0);
		boolean exit = false;
		switch (response) {
			case 1:
				Dice.home();
				break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("invalid option");
		}
	}
}
