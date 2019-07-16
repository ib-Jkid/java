package main;

import investment.Assets;
import investment.Bank;
import investment.Factory;
import investment.Refinery;

public class Timer {
	
	public static void timeLoop() {
		while(!Man.gameOver) {
			try {
				
				Thread.sleep(10000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			update();
			
		}
	}

	private static void update() {
		// TODO Auto-generated method stub
		Bank.updateIncome();
		Factory.updateIncome();
		Refinery.updateIncome();
		Assets.updateIncome();
		Money.updateLimit();
		
		Assets.profitStock += Assets.totalIncomeRate;
		Money.serviceLoan();
		System.out.println("updated");
		
	}
	


}
