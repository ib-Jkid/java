package investment;

import main.Man;

public class Bank extends Assets {
	private static final Double ASSETCOST = 2000.0;
	private static final Double BUYING = 1000.0;
	private static int owned = 0;
	private static final Double AVERAGEINCOME = 2.5;
	public static Double income;
	public static void updateIncome() {
		income = owned * AVERAGEINCOME;
	}

	public static void trade (Assets asset) {
		boolean exit = false;
		System.out.printf("YOUR ASSET SUMMARY \n"
				+ "Total bank owned: %s \n"
				+ "Income: $%s\n",owned,income);
		while(!exit) {
			System.out.printf("What would you like to Do?"
					+ "1: Buy bank \n"
					+ "2: Sell bank \n"
					+ "3: Exit\n");
			int response = getResponse(0);
			if(response == 1) {
				buyAsset(asset);
				
			}else if(response == 2) {
				sellAsset(asset);
			}else if(response == 3) {
				exit= true;
				
			}else {
				System.out.println("invalid response");
			}
		}
	}
	
	public static void sellAsset(Assets asset) {
		System.out.printf("So sad you have to sell\n"
				+ "Bank owned: "+owned+"\n"
				+ "Selling price: $"+BUYING+"\n");
		System.out.println("How many Banks do you want to Sell?");
		int num = getResponse(0);
		if(num > owned) {
			System.out.println("you do not have up to "+num+" Banks");
		}else if(num <= owned) {
			Man.dollarAtHand += BUYING * num;
			owned -= num;
			System.out.println("You have sold "+num+ " banks your are now left with "+owned);
		}
		
	}

	public static void buyAsset (Assets asset) {
		System.out.printf("This is the Bank \n "
				+ "we would put in a lot of hard work to making you RICH!!!\n"
				+ "Cost per Factory: "+ASSETCOST+"\n"
				+ "Average income: "+AVERAGEINCOME+"\n");
		System.out.println("How many bank do you want to Buy?");
		int num = getResponse(0);
		Double cost = num * ASSETCOST;
		if(cost > Man.dollarAtHand) {
			System.out.println("Sorry you only have $"+ Man.dollarAtHand +" at hand");
		}else if (cost <= Man.dollarAtHand) {
			Man.dollarAtHand -= cost;
			owned += num;
			System.out.println("You have Bought "+num+ " bank your are now have "+owned);
		}
	
		
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
