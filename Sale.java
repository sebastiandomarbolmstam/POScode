package se.kth.IV1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.IV1350.dbHandler.ItemDTO;

/**
 *Class that handles business logic and operations.
 */
public class Sale {
	private LocalDateTime saleTime;
	List<ItemDTO> shopingList = new ArrayList<ItemDTO>();
	private boolean itemFound = false;
	private double runningTotal;
	private SaleDTO activeSaleDTO;
	private int newQuantity;
	
	/**
	 * Creates an instance of {@link Sale} and records the time at which the sale started.
	 */
	public Sale() {
		this.saleTime = LocalDateTime.now();
	}
	
	/**
	 * @return time of sale start
	 */
	public LocalDateTime getTime() {
		return this.saleTime;
	}
	
	/**
	 * Adds item to list of entered items and calculates total price.
	 * @param currentItem New item to be added to list.
	 * @return updated sale information after the new item has been added. 
	 */
	public SaleDTO addItem(ItemDTO currentItem) {
		updateShopingList(currentItem);
		runningTotal = calculateTotal(shopingList);
		activeSaleDTO = new SaleDTO(currentItem, shopingList, runningTotal, saleTime); 
		return activeSaleDTO;
	}

	private double calculateTotal(List<ItemDTO> updatedShopingList) {
		runningTotal = 0;
		for(ItemDTO item : updatedShopingList) {
			runningTotal += item.getPrice() * item.getQuantity(); 
		}
		return runningTotal;
	}

	private void updateShopingList(ItemDTO currentItem) {
		for(ItemDTO item : shopingList) {
			if(item.getID().equals(currentItem.getID())) {
				itemFound = true;
				newQuantity = currentItem.getQuantity() + item.getQuantity();
				item.setQuantity(newQuantity);
			}
		}
		
		if(!itemFound) {
			shopingList.add(currentItem);
		}
	}
}
