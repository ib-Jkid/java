package work;

import main.Man;
import main.Man.Workplace;

public class Banking extends Jobs {
	static Double salary = 18000.0;
	
	static void jobSearch () {
		if(Man.employed == false && Man.workplace != Workplace.BANK) {
			System.out.printf("Welcome to the Bank do you want to work here?\n"
					+ "1: Yes\n"
					+ "2: No\n");
			int response = getResponse(0);
			if(response == 1) {
				interview();
			}
			
		}else {
			System.out.println("You already work here");
		}
	}
	static void work() {
		if(Man.employed == true && Man.workplace == Workplace.BANK) {
			startWork();
		}else {
			System.out.println("you dont work here");
		}
	}
	public static void home() {
		boolean exit = false;
		while(!exit) {
			System.out.printf("Welcome to the bank what are you here for? \n"
					+ "1: Job Search \n"
					+ "2: work \n"
					+ "3: exit \n");
			int response = getResponse(0);
			switch (response) {
				case 1:
					jobSearch();
					break;
				case 2:
					work();
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("invalid option");
			}
		}
		
		
		
	}
	
	
	static void pay() {
		Man.nairaAtHand += salary;
		System.out.println("WELLDONE TAKE YOUR PAY");
		System.out.println("WE HOPE TO SEE YOU SOON");
	}

	private static void startWork() {
		System.out.println("working....");
		try {
			Thread.sleep(5000);
			pay();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}

	private static void interview() {
		int ans = 0;
		int response = 0;
		//////////////////////////////////////////////////////////
		System.out.println("What is the square root of 36 ?");
		response = getResponse(3);
		if(response == 6)
			ans += 2;
		////////////////////////////////////////////////////////////////
		System.out.println("What is the sum of 12 and 9 ?");
		response = getResponse(3);
		if(response == 21)
			ans += 2;
		/////////////////////////////////////////////////////////////////
		System.out.println("What is the product of 12 and 2 ?");
		response = getResponse(3);
		if(response == 24)
			ans += 2;
		////////////////////////////////////////////////////////////////
		System.out.println("What is the square of 5 ?");
		response = getResponse(3);
		if(response == 25)
			ans += 2;
		////////////////////////////////////////////////////////////////
		System.out.println("Give a prime number between 2 & 6 ?");
		response = getResponse(3);
		if(response == 5)
		ans += 2;
		
		
		if(ans >= 5) {
			System.out.println("Congratulation you have been employed");
			Man.employed = true;
			Man.workplace = Man.Workplace.BANK;
		}else if(ans < 5) {
			System.out.println("you are not what we are looking for");
		}
		
	}
	

}
