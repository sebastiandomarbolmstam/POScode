package se.kth.IV1350.model;

import java.time.LocalDateTime;
import java.util.List;

import se.kth.IV1350.dbHandler.ItemDTO;

/**
 *Collects all information about the sale.
 */
public class SaleDTO {

	private ItemDTO currentItem;
	private List<ItemDTO> shopingList;
	private double runningTotal;
	private LocalDateTime saleTime;

	/**
	 * Creates an instance of SaleDTO.
	 * @param currentItem information about the most recently added item.
	 * @param shopingList list of all added items and quantity of these items.
	 * @param runningTotal current total price of the goods.
	 * @param saleTime time when the specific sale started.
	 */
	public SaleDTO(ItemDTO currentItem, List<ItemDTO> shopingList, double runningTotal, LocalDateTime saleTime) {
		this.currentItem = currentItem;
		this.shopingList = shopingList;
		this.runningTotal = runningTotal;
		this.saleTime = saleTime;
	}
	
	/**
	 * @return Most recently added item (to be viewed when scanning items).
	 */
	ItemDTO getCurrentItem() {
		return this.currentItem;
	}
	
	/**
	 * @return A complete list of added items and quantities.
	 */
	List<ItemDTO> getShopingList(){
		return this.shopingList;
	}
	
	/**
	 * @return total price, taxes not included.
	 */
	public double getRunningTotal() {
		return this.runningTotal;
	}
	
	/**
	 * @return time when sale started.
	 */
	LocalDateTime getTimeOfSale() {
		return this.saleTime;
	}

	/**
	 * creates printable string containing information about the ongoing sale.
	 */
	public String toString() {
		String saleString = "";
		StringBuilder sb = new StringBuilder();
		for(ItemDTO item : this.shopingList) {
			sb.append(item.toString() + "\n"); 
		}
		
		saleString = sb.toString();
		return saleString;
	}
}
