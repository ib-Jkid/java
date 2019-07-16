package main;

import investment.Assets;

public class Money extends Listener{
	private Double dollar = 1000.0;
	private Double naira = 1000.0;
	private Double pound = 1000.0;
	public static Double dept = 0.0;
	public static Double loanLimit = 0.0;
	public static void updateLimit() {
		loanLimit = Assets.totalIncomeRate * 10;
	}
	public static void banking(Money money) {
		
		boolean exit = false;
		while (!exit) {
			System.out.printf("*******WELCOME TO THE BANK********\n"
					+ "What would you like to do? \n"
					+ "1: Make a deposite \n"
					+ "2: Check Account balance \n"
					+ "3: Withdraw cash \n"
					+ "4: Get Loan \n"
					+ "5: Change Money \n"
					+ "6: exit\n");
			int response = getResponse(0);
			switch (response) {
				case 1:
					money.deposite(money);
					break;
				case 2:
					money.checkAccount();
					break;
				case 3:
					money.withdraw(money);
					break;
				case 4:
					money.getLoan(money);
					break;
				case 5:
					money.changeCurrency(money);
					break;
				case 6:
					exit = true;
					break;
				default:
					System.out.println("Invalid selection");
					break;
			}
		}
	}
	/*****************************************
	 * Getting loan from the bank
	 * 
	 * 
	 * 
	 * 
	 */
	public static void serviceLoan() {
		if (dept > 0.0) {
			if (Assets.profitStock < dept) {
				dept -= Assets.profitStock;
				Assets.profitStock = 0.0;
			}else if(Assets.profitStock >= dept) {
				Assets.profitStock -= dept;
				dept = 0.0;
			}
			
		}
	}
	public void getLoan(Money money) {
		if(dept <= 0.0) {
			System.out.printf("Your Loan Limit is "+ loanLimit + " do you want to continue?\n"
					+ "1: Yes\n"
					+ "2: No\n");
		}else {
			System.out.println("You have outstanding dept");
		}
		
		
	}
	/********************************************
	 * withdrawing money from account
	 * 
	 * 
	 * 
	 */
	public void withdraw(Money money) {
		String currency = null;
		Double response2 = null;
		int response = 0;
		System.out.printf("Which currency would you like to withdraw? \n"
				+ "1: Dollar\n"
				+ "2: Naira\n"
				+ "3: Pound\n"
				+ "4: exit\n");
		response = getResponse(0);
		boolean exit = false;
		while(!exit) {
			switch (response) {
				case 1:
					currency = "dollar";
					exit = true;
					break;
				case 2:
					currency = "naira";
					exit = true;
					break;
				case 3:
					currency = "pound";
					exit = true;
					break;
				case 4:
					exit = true;
					break;
				default: 
					System.out.println("Invalid selection");
					break;
			}
		}
		if(currency != null) {
			System.out.println("How much would you like to withdraw?");
			response2 = getResponse(0.1);
		}
		if (currency == "dollar") {
			if(response2 >= Man.dollarAtHand) {
				System.out.printf("Are you sure you want to withdraw $"+response2+" \n"
						+ "1: Yes \n"
						+ "2: No\n");
				int response3 = getResponse(0);
				if(response3 == 1) {
					if(money.spendMoneyDollar(response2)) {
						Man.dollarAtHand += response2;
					}
				}
			}
			
		}
		if (currency == "naira") {
			if(response2 >= Man.nairaAtHand) {
				System.out.printf("Are you sure you want to withdraw N"+response2+" \n"
						+ "1: Yes \n"
						+ "2: No\n");
				int response3 = getResponse(0);
				if(response3 == 1) {
					if(money.spendMoneyNaira(response2)) {
						Man.nairaAtHand += response2;
					}
				}
			}
			
		}
		if (currency == "pound") {
			if(response2 >= Man.poundAtHand) {
				System.out.printf("Are you sure you want to withdraw E"+response2+" \n"
						+ "1: Yes \n"
						+ "2: No\n");
				int response3 = getResponse(0);
				if(response3 == 1) {
					if(money.spendMoneyPound(response2)) {
						Man.poundAtHand += response2;
					}
				}
			}
			
		}
	}
	/*******************************************
	 * Depositing money into the accounts
	 * @param money
	 */
	public void deposite(Money money) {
		String currency = null;
		int response =  0;
		Double response2 = null;
		System.out.printf("Which currency would you like to deposite? \n"
				+ "1: Dollar\n"
				+ "2: Naira\n"
				+ "3: Pound\n"
				+ "4: exit\n");
		response = getResponse(0);
		boolean exit = false;
		while(!exit) {
			switch (response) {
				case 1:
					currency = "dollar";
					exit = true;
					break;
					
				case 2:
					currency = "naira";
					exit = true;
					break;
				case 3:
					currency = "pound";
					exit = true;
					break;
				case 4:
					exit = true;
					break;
				default: 
					System.out.println("Invalid selection");
					break;
			}
		}
		if(currency != null) {
			System.out.println("How much would you like to deposite?");
			response2 = getResponse(0.1);
		}
		///////////////////////////////////////////////////
		if (currency == "dollar") {
			if(response2 <= Man.dollarAtHand) {
				System.out.printf("Are you sure you want to deposite $"+response2+" \n"
						+ "1: Yes \n"
						+ "2: No\n");
				int response3 = getResponse(0);
				if(response3 == 1) {
					money.earnMoneyDollar(response2);
				}
			}else {
				System.out.println("You do not have that amount of money");
			}
			
		}
		////////////////////////////////////////////////
		else if (currency == "naira") {
			if(response2 <= Man.nairaAtHand) {
				System.out.printf("Are you sure you want to deposite N"+response2+" \n"
						+ "1: Yes \n"
						+ "2: No\n");
				int response3 = getResponse(0);
				if(response3 == 1) {
					money.earnMoneyNaira(response2);
				}
			}else {
				System.out.println("You do not have that amount of money");
			}
			
		}
		///////////////////////////////////////////
		else if (currency == "pound") {
			if(response2 <= Man.poundAtHand) {
				System.out.printf("Are you sure you want to deposite E"+response2+" \n"
						+ "1: Yes \n"
						+ "2: No\n");
				int response3 = getResponse(0);
				if(response3 == 1) {
					money.earnMoneyPound(response2);
				}
			}else {
				System.out.println("You do not have that amount of money");
			}
			
		}
		////////////////////////////////////////////////////
	}
	/**************************************
	 * 
	 * @param earnMoney
	 * when money is being made the following
	 * function is called based on the currency
	 */
	public void earnMoneyDollar(Double dollar) {
		this.dollar += dollar;
		System.out.printf("Your have deposited $"+dollar +
				" in your account,\n Your Dollar Account Balance is $"+this.dollar+"\n");
		getResponse("a");
	}
	public void earnMoneyNaira(Double naira) {
		this.naira += naira;
		System.out.printf("Your have deposited N"+naira +
				" in your account,\n Your Naira Account Balance is $"+this.naira+"\n");
		getResponse("a");
	}
	public void earnMoneyPound(Double pound) {
		this.pound += pound;
		System.out.printf("Your have deposited E"+pound +
				" in your account,\n Your Pound Account Balance is $"+this.pound+"\n");
		getResponse("a");
	}
	/**************************************
	 * 
	 * @param earnMoney
	 * when money is being spent the following
	 * function is called based on the currency
	 */
	public boolean spendMoneyDollar(Double dollar) {
		if(this.dollar >= dollar) {
			this.dollar -= dollar;
			System.out.println("You have Spent $"+dollar +" your have $"+this.dollar+ 
					" in your account\n");
			getResponse("a");
			return true;
		}else {
			System.out.println("Insufficient fund in the Dollar account you "
					+ "have $"+this.dollar+ " in your account\n");
			getResponse("a");
			return false;
		}
	}
	public boolean spendMoneyNaira(Double naira) {
		if(this.naira >= naira) {
			this.naira -= naira;
			System.out.println("You have Spent $"+naira +" your have $"+this.naira+ 
					" in your account\n");
			getResponse("a");
			return true;
		}else {
			System.out.println("Insufficient fund in the Dollar account you "
					+ "have $"+this.naira+ " in your account\n");
			getResponse("a");
			return false;
		}
	}
	public boolean spendMoneyPound(Double pound) {
		if(this.pound >= pound) {
			this.pound -= pound;
			System.out.println("You have Spent $"+pound +" your have $"+this.pound+ 
					" in your account\n");
			getResponse("a");
			return true;
		}else {
			System.out.println("Insufficient fund in the Dollar account you "
					+ "have $"+this.pound+ " in your account\n");
			getResponse("a");
			return false;
		}
	}
	/****************************************
	 * checking account balance
	 */
	public void checkAccount() {
		System.out.println("Sir this is your Account Balance");
		System.out.println("Dollar: $"+this.dollar);
		System.out.println("Naira: N"+this.naira);
		System.out.println("Pound: E"+this.pound);
		getResponse("");
	}
	/***********************************
	 * getters and setters for various currency
	 * @return
	 */
	/*public Double getDollar() {
		return dollar;
	}
	public void setDollar(Double dollar) {
		this.dollar = dollar;
	}
	public Double getNaira() {
		return naira;
	}
	public void setNaira(Double naira) {
		this.naira = naira;
	}
	public Double getPound() {
		return pound;
	}
	public void setPound(Double pound) {
		this.pound = pound;
	}*////////////////////////////////////////////
	/*******************************************
	 * Bearu de Change
	 * @param money
	 */
	//////////////////////////////////
	public void changeCurrency(Money money) {
		boolean exit = false;
		String fromCurrency = null;
		String toCurrency = null;
		Double amount = null;
		while(!exit) {
			System.out.printf("From which Currency would you like to change? \n"
					+ "1: Dollar \n"
					+ "2: Naira \n"
					+ "3: Pound \n"
					+ "4: EXIT\n");
			int response = getResponse(0);
			switch (response) {
				case 1:
					fromCurrency = "dollar";
					exit = true;
					break;
				case 2:
					fromCurrency = "naira";
					exit = true;
					break;
				case 3:
					fromCurrency = "pound";
					exit = true;
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("invalid response try again");
			}
		}
		exit = false;
		while(!exit) {
			System.out.printf("To which currency are you changing to? \n"
					+ "1: Dollar \n"
					+ "2: Naira \n"
					+ "3: Pound \n"
					+ "4: EXIT\n");
			int response = getResponse(0);
			switch (response) {
			case 1:
				toCurrency = "dollar";
				exit = true;
				break;
			case 2:
				toCurrency = "naira";
				exit = true;
				break;
			case 3:
				toCurrency = "pound";
				exit = true;
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("invalid response try again");
			}
		}
		
		
			System.out.println("How much do you want to change?");
			amount = getResponse(0.1);
		
			if(fromCurrency == "dollar") {
				if(toCurrency == "naira") {
					money.spendMoneyDollar(amount);
					money.earnMoneyNaira(amount * 360);
				}
				else if(toCurrency == "pound") {
					money.spendMoneyDollar(amount);
					money.earnMoneyPound(amount / 1.5);
				}
					
			}
			

			if(fromCurrency == "naira") {
				if(toCurrency == "pound") {
					money.spendMoneyNaira(amount);
					money.earnMoneyPound(amount / 450);
				}
				else if(toCurrency == "dollar") {
					money.spendMoneyNaira(amount);
					money.earnMoneyDollar(amount / 360);
				}
					
			}
			

			if(fromCurrency == "pound") {
				if(toCurrency == "naira") {
					money.spendMoneyPound(amount);
					money.earnMoneyNaira(amount * 450);
				}
				else if(toCurrency == "dollar") {
					money.spendMoneyPound(amount);
					money.earnMoneyDollar(amount * 1.5);
				}
					
			}
		
	}
}
