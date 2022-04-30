package com.techelevator;

/***********************************************************************************************************************
 * 				Capstone Project-1 for the Merit America Java Bootcamp
 * @description	A simple vending machine program
 * @authors		Bradley Sawyer & Hayden Gilbert
 * @date		04.18.2022
 * @version		1.0
 * @copyright	None
 **********************************************************************************************************************/

import com.techelevator.view.Menu;

import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT};

	private Menu menu;
	public Inventory inventory = new Inventory();
	public Money money = new Money();

	public Scanner userInput = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void mainMethod(){
		System.out.println("(1) Feed Money \n(2) Select Product \n(3) Finish Transaction");
		String input = userInput.nextLine();
		switch (input){
			case "1":
				//feed money
				money.feedMoney();
				break;
			case"2":
				//displays and makes purchase
				inventory.displayProducts();
				money.makePurchase();
				break;
			case"3":
				//finish transaction
				System.out.println("-clink-");
				System.out.println(money.returnChange(money.getCurrentMoney()));
				money.nextCustomerPlease();
				break;
			case"4":
				//secret menu item
				for(Map.Entry<String, Integer> auditer : Money.salesReport.entrySet()){
					AuditLog.salesReport(auditer.getKey(),auditer.getValue());
				}
				try{
					AuditLog.printSalesTotal();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println(System.lineSeparator() + "*** " + input + " is not a valid option ***" + System.lineSeparator()+"Would you like to try again?[Y or N]");
				//check on this
				String yOrN="";
				try{
					yOrN = userInput.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(yOrN.equalsIgnoreCase("y")){
					mainMethod();
				}else{
					break;
				}
		}
	}

	public void run() {
		//creates inventory at beginning of run
		inventory.createInventory();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				inventory.displayProducts();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				//popped the main screen in a method
				mainMethod();

			}else if(choice.equalsIgnoreCase(MAIN_MENU_OPTION_EXIT)){
				System.out.println("-clink-");
				System.out.println(money.returnChange(money.getCurrentMoney()));
				money.exitedBeforeFinish();
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
