package se.kth.IV1350.model;

/**
 *Handles all information and functionality regarding the end of the sale, when all items has been added
 *to the sale.
 */
public class CompleteSale {

	private double change;
	private String infoToPrint;
	private double totalWithTaxes;
	private double TAX_RATE = 1.10;
	
	/**
	 * Creates an empty instance of {@link Complete Sale}.
	 */
	public CompleteSale() {	
	}
	
	/**
	 * Puts together all information concerning the sale.
	 * 
	 * @param activeSaleDTO Contains all information about the sale. Is used to calculate change,
	 * totalWithTaxes and to provide overall information about the sale.
	 * @param paidAmount Amount paid by customer. Is used to calculate change.
	 * @return Instance of EndOfSaleDTO containing complete information about the sale.
	 */
	public EndOfSaleDTO assembleSaleInformation(SaleDTO activeSaleDTO, double paidAmount) {
		totalWithTaxes = calculateFinalTotal(activeSaleDTO);
		change = calculateChange(totalWithTaxes, paidAmount);
		EndOfSaleDTO saleInformation = new EndOfSaleDTO(activeSaleDTO, change, paidAmount, totalWithTaxes);
		return saleInformation;
	}
	
	private double calculateFinalTotal(SaleDTO activeSaleDTO) {
		return activeSaleDTO.getRunningTotal() * TAX_RATE;
	}

	private double calculateChange(double runningTotal, double paidAmount) {
		return paidAmount - runningTotal;
	}
	
	/**
	 * Creates a printable string representing a receipt.
	 * @param saleInformation All information that is to be printed
	 * @return Receipt as a printable string. 
	 */
	public String createReceipt(EndOfSaleDTO saleInformation) {
		Receipt receipt = new Receipt();
		infoToPrint = receipt.toString(saleInformation);
		return infoToPrint;	
	}
}
