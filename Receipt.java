package se.kth.IV1350.model;

/**
 *Handles format of the receipt to be printed. 
 */
class Receipt {
	
	/**
	 * Creates an empty instance of {@link Receipt}.
	 */
	Receipt() {
	}

	/**
	 * Creates a printable string that represents a receipt.
	 * @param saleInformation contains information about the sale that should be included in receipt.
	 * @return printable string representing a receipt.
	 */
	String toString(EndOfSaleDTO saleInformation) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n**************RECEIPT**************");
		sb.append("\n\nTime of sale: " + saleInformation.getSaleDTO().getTimeOfSale());
		sb.append("\n\n" + saleInformation.getSaleDTO().toString());
		sb.append("\n\nTotal:\t\t\t" + saleInformation.getSaleDTO().getRunningTotal() + "$");
		sb.append("\nTotal with taxes:\t" + String.format("%.2f", saleInformation.getTotalWithTaxes()) + "$");
		sb.append("\nAmount paid:\t\t" + saleInformation.getPaidAmount() + "$");
		sb.append("\n-----------------------------------");
		sb.append("\nChange:\t\t\t" + String.format("%.2f", saleInformation.getChange()) + "$");
		sb.append("\n\n**********HAVE A NICE DAY**********");
		
		return sb.toString();
	}
}
