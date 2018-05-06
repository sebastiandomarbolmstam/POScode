package se.kth.IV1350.dbHandler;

import java.util.ArrayList;
import java.util.List;

import se.kth.IV1350.model.EndOfSaleDTO;

/**
 *Represents a system that keeps track of items available at the store. 
 */
public class ItemInventory {
	List<ItemDTO> availableItems = new ArrayList<ItemDTO>();
	
	/**
	 * Creates a new inventory and fills a list with available items.
	 */
	public ItemInventory() {
		availableItems.add(new ItemDTO("banana", 1.50, "12345", 0));
		availableItems.add(new ItemDTO("strawberrys", 4.50, "12346", 0));
	}

	/**
	 * Searches inventory list for items matching the item entered by cashier.
	 * 
	 * @param itemIdentifier Identifier of entered item that is used for comparing with items in inventory list. 
	 * @param quantity Number of items with the specific identifier.
	 * @return instance of ItemDTO for the entered item. If no match is found the method returns null.
	 */
	public ItemDTO findItemDTO(String itemIdentifier, int quantity) {
		for(ItemDTO item : availableItems) {
			if(item.getID().equals(itemIdentifier)) {
				ItemDTO currentItem = new ItemDTO(item.getName(), item.getPrice(), item.getID(), quantity);
				return currentItem;
			}
		}
		return null;
	}

	
	/**
     * A placeholder for a inventory system that could be updated. Prints a false indication that the inventory
     * has been updated. 
     * 
	 * @param saleInformation Used to represent the information that should have been sent to update inventory.
	 */
	public void updateItemInventory(EndOfSaleDTO saleInformation) {
		System.out.println("Inventory System updated.");
		
	}

}
