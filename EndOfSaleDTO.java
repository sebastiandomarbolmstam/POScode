package se.kth.IV1350.model;

/**
 *Collects all information about a completed sale.
 */
public class EndOfSaleDTO {

	private SaleDTO activeSaleDTO;
	private double change;
	private double paidAmount;
	private double totalWithTaxes;
	
	/**
	 * Creates an instance of EndOfSaleDTO.
	 * @param activeSaleDTO Contains information about the sale.
	 * @param change How much money is to be given back to customer.
	 * @param paidAmount How much money customer has paid.
	 * @param totalWithTaxes Calculated cost after taxes at a set rate is added to total price.
	 */
	EndOfSaleDTO(SaleDTO activeSaleDTO, double change, double paidAmount, double totalWithTaxes) {
		this.activeSaleDTO = activeSaleDTO;
		this.change = change;
		this.paidAmount = paidAmount;
		this.totalWithTaxes = totalWithTaxes;
	}
	
	/**
	 * @return SaleDTO containing information about sale.
	 */
	SaleDTO getSaleDTO() {
		return this.activeSaleDTO;
	}
	
	/**
	 * @return Amount of change that should be returned to customer.
	 */
	double getChange() {
		return this.change;
	}
	
	/**
	 * @return Amount paid by customer.
	 */
	double getPaidAmount() {
		return this.paidAmount;
	}
	
	/**
	 * @return Total cost of purchase with taxes included.
	 */
	double getTotalWithTaxes() {
		return this.totalWithTaxes;
	}
}
