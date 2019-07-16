package investment;

import main.Man;

public class Refinery extends Assets {
	private static final Double ASSETCOST = 5000.0;
	private static final Double BUYING = 2000.0;
	private static int owned = 0;
	private static final Double AVERAGEINCOME = 10.0;
	public static Double income;
	public static void updateIncome() {
		income = owned * AVERAGEINCOME;
	}

	public static void trade (Assets asset) {
		boolean exit = false;
		System.out.printf("YOUR ASSET SUMMARY \n"
				+ "Total refinery owned: %s \n"
				+ "Income: $%s\n",owned,income);
		while(!exit) {
			System.out.printf("What would you like to Do?"
					+ "1: Buy refinery \n"
					+ "2: Sell refinery \n"
					+ "3: Exit \n");
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
				+ "refinery owned: "+owned+"\n"
				+ "Selling price: $"+BUYING+"\n");
		System.out.println("How many refinery do you want to Sell?");
		int num = getResponse(0);
		if(num > owned) {
			System.out.println("you do not have up to "+num+" refinery");
		}else if(num <= owned) {
			Man.dollarAtHand += BUYING * num;
			owned -= num;
			System.out.println("You have sold "+num+ " refinery your are now left with "+owned);
		}
		
	}

	public static void buyAsset (Assets asset) {
		System.out.printf("This is the refinery \n "
				+ "we would put in a lot of hard work to making you RICH!!!\n"
				+ "Cost per refinery: "+ASSETCOST+"\n"
				+ "Average income: "+AVERAGEINCOME+"\n");
		System.out.println("How many refinery do you want to Buy?");
		int num = getResponse(0);
		Double cost = num * ASSETCOST;
		if(cost > Man.dollarAtHand) {
			System.out.println("Sorry you only have $"+ Man.dollarAtHand +" at hand");
		}else if (cost <= Man.dollarAtHand) {
			Man.dollarAtHand -= cost;
			owned += num;
			System.out.println("You have Bought "+num+ " refineries your are now have "+owned);
		}
	
		
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
