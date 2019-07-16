package investment;
import main.Man;

public class Factory extends Assets {
	
	private static final Double ASSETCOST = 1200.0;
	private static final Double BUYING = 600.0;
	private static int owned = 0;
	private static final Double AVERAGEINCOME = 1.0;
	public static Double income; 
	public static void updateIncome() {
		income = owned * AVERAGEINCOME;
	}

	public static void trade (Assets asset) {
		boolean exit = false;
		System.out.printf("YOUR ASSET SUMMARY \n"
				+ "Total factory owned: %s \n"
				+ "Income: $%s \n",owned,income);
		while(!exit) {
			System.out.printf("What would you like to Do?"
					+ "1: Buy factory \n"
					+ "2: Sell factory \n"
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
				+ "Factory owned: "+owned+"\n"
				+ "Selling price: $"+BUYING+"\n");
		System.out.println("How many factory do you want to Sell?");
		int num = getResponse(0);
		if(num > owned) {
			System.out.println("you do not have up to "+num+" factories");
		}else if(num <= owned) {
			Man.dollarAtHand += BUYING * num;
			owned -= num;
			System.out.println("You have sold "+num+ " factories your are now left with "+owned);
		}
		
	}

	public static void buyAsset (Assets asset) {
		System.out.printf("This is the factory \n "
				+ "we would put in a lot of hard work to making you RICH!!!\n"
				+ "Cost per Factory: "+ASSETCOST+"\n"
				+ "Average income: "+AVERAGEINCOME+"\n");
		System.out.println("How many factory do you want to Buy?");
		int num = getResponse(0);
		Double cost = num * ASSETCOST;
		if(cost > Man.dollarAtHand) {
			System.out.println("Sorry you only have $"+ Man.dollarAtHand +" at hand");
		}else if (cost <= Man.dollarAtHand) {
			Man.dollarAtHand -= cost;
			owned += num;
			System.out.println("You have Bought "+num+ " factories your are now have "+owned);
		}
	
		
	}


	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}