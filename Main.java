package se.kth.IV1350.startUp;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.dbHandler.AccountingSystemHandler;
import se.kth.IV1350.dbHandler.ItemInventory;
import se.kth.IV1350.dbHandler.Printer;
import se.kth.IV1350.view.View;

/**
 * Starts the entire application.
 */
public class Main {

	/**
	 * 
	 * @param args The program does not take any command line parameters.
	 */
	public static void main(String[] args) {
		
		AccountingSystemHandler accSys = new AccountingSystemHandler();
		Printer printer = new Printer();
		ItemInventory inventory = new ItemInventory();
		Controller contr = new Controller(inventory, printer, accSys);
		View view = new View(contr);
		
		view.sampleExecution();
	}

}
