package investment;

import main.Listener;

public class Assets extends Listener {
	public static Double totalIncomeRate;
	public static Double profitStock = 0.0;
	public static void updateIncome() {
		totalIncomeRate = Factory.income + Bank.income + Refinery.income;
	}
	
	public static void startTrading (Assets asset) {
		
		boolean exit = false;
		while(!exit) {
			System.out.printf("Choose Your Asset \n"
					+ "1: Factory \n"
					+ "2: Bank \n"
					+ "3: Refinery\n"
					+ "4: summary\n"
					+ "5: exit\n");
			int response = getResponse(0);
			if(response == 1) {
				Factory.trade(asset);
				
			}
			else if(response == 2) {
				Bank.trade(asset);
			}
			else if(response == 3) {
				Refinery.trade(asset);
			}
			else if(response == 4) {
				summary();
				
			}else if(response == 5) {
				exit = true;
				
			}else {
				System.out.println("Invalid response");
			}
		}
	}

	private static void summary() {
		System.out.println(totalIncomeRate+"/"+profitStock);
		
	}
	
	

}
