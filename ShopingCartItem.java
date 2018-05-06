package se.kth.IV1350.view;

/**
 * Collects necessary information on items to be added to sale.
 */
class ShoppingCartItem {
	
	private String itemIdentifier;
	private int quantity;

	/**
	 * Creates instance of {@link ShoppingCartItem}. 
	 * @param itemIdentifier identifier of item to be added.
	 * @param quantity Number of items with same identifier.
	 */
	ShoppingCartItem(String itemIdentifier, int quantity) {
		this.itemIdentifier = itemIdentifier;
		this.quantity = quantity;
	}
	
	/**
	 * @return identifier of item to be added.
	 */
	String getIdentifier() {
		return this.itemIdentifier;
	}
	
	/**
	 * @return Number of items to be added.
	 */
	int getQuantity() {
		return this.quantity;
	}

}
