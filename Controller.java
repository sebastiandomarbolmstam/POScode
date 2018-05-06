package se.kth.IV1350.controller;

import se.kth.IV1350.dbHandler.AccountingSystemHandler;
import se.kth.IV1350.dbHandler.ItemDTO;
import se.kth.IV1350.dbHandler.ItemInventory;
import se.kth.IV1350.dbHandler.Printer;
import se.kth.IV1350.model.EndOfSaleDTO;
import se.kth.IV1350.model.CompleteSale;
import se.kth.IV1350.model.Sale;
import se.kth.IV1350.model.SaleDTO;

/**
 * The only controller in the application. Controller is responsible for all method calls to model. 
 */
public class Controller {

	private Sale currentSale;
	private ItemInventory inventory;
	private ItemDTO currentItem;
	private SaleDTO activeSaleDTO;
	private Printer printer;
	private EndOfSaleDTO saleInformationDTO;
	private String infoToPrint;
	private AccountingSystemHandler accSys;
	
	/**
	 * Constructs a new controller using the specified inventory, printer and accounting system accSys.
	 * 
	 * @param inventory This inventory is used to keep track of the items available for sale.
	 * @param printer This printer is used to print a receipt containing all information about the sale.
	 * @param accSys This instance of {@link AccountingSystemHandler} is used as a representation of a 
	 * accounting system that is not included in the application.
	 */
	public Controller(ItemInventory inventory, Printer printer, AccountingSystemHandler accSys) {
		this.inventory = inventory;
		this.printer = printer;
		this.accSys = accSys;
	}

	/**
	 * Creates an instance of {@link Sale}, which will be used for handling all operations and
	 * information regarding input and calculations during the ongoing sale.
	 */
	public void startSale() {
		currentSale = new Sale();
	}

	/**
	 * Responsible for handling a new item entered by the cashier. 
	 * 
	 * @param itemIdentifier Is entered by cashier and is used to find matching items in inventory. 
	 * @param quantity Is entered by cashier and tells how many items with the given identifier that shuold be
	 * added to sale.
	 * @return Returns a SaleDTO containing information about the sale after item is scanned. Returns null if 
	 * no item with the given identification is found in inventory.
	 */
	public SaleDTO scanItem(String itemIdentifier, int quantity) {
		currentItem = inventory.findItemDTO(itemIdentifier, quantity);
		if(currentItem != null) {
			return activeSaleDTO = currentSale.addItem(currentItem);
		}
		System.out.println("-Item identifier invalid-\n");
		return null;
	}

	/**
	 * Responsible for ending a sale after all items has been entered. 
	 * 
	 * @param paidAmount Amount of money the customer has given to pay. Is used to calculate how much money 
	 * that should be returned as change.
	 */
	public void pay(double paidAmount) {
		CompleteSale completedSale = new CompleteSale();
		saleInformationDTO = completedSale.assembleSaleInformation(activeSaleDTO, paidAmount);
		accSys.updateAccountingSystem(saleInformationDTO);
		inventory.updateItemInventory(saleInformationDTO);
		infoToPrint = completedSale.createReceipt(saleInformationDTO);
		printer.printReceipt(infoToPrint);
	}
}
