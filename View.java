package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.model.SaleDTO;

/**
 *Placeholder for view. Makes calls to the controller.
 */
public class View {
	
	private Controller contr;
	
	/**
	 * Creates a new view using the specified controller.
	 * @param contr controller to be used for all system operations.
	 */
	public View(Controller contr) {
		this.contr = contr;
	}

	/**
	 * Simulates a sample execution containing calls to all system operations. 
	 */
	public void sampleExecution() {
		
		CustomerDummy customer = new CustomerDummy();
		contr.startSale();
		System.out.println("Welcome!\n\n");
		for(ShoppingCartItem item : customer.getShoppingCart()) {
			SaleDTO activeSaleDTO = contr.scanItem(item.getIdentifier(), item.getQuantity());
			if(activeSaleDTO != null) {
			System.out.println(activeSaleDTO.toString() + "Running total:\t" + activeSaleDTO.getRunningTotal() + "$\n");
			}
		}

		contr.pay(customer.getAmountPaid());
	}

}
