package se.kth.IV1350.dbHandler;

import se.kth.IV1350.model.EndOfSaleDTO;

/**
 * A class acting as a placeholder for a functioning accounting system.
 */
public class AccountingSystemHandler {

	/**
	 * Creates an empty instance of {@link AccountingSystemHandler}.
	 */
	public AccountingSystemHandler() {
	}

	/**
	 * Gives a false notification to user that the accounting system has been updated after completed sale.
	 * 
	 * @param saleInformation Is only used to represent the information that should have been sent to a real
	 * accounting system.
	 */
	public void updateAccountingSystem(EndOfSaleDTO saleInformation) {
		System.out.println("Sale Information sent to accounting system.");
		
	}

}
