package se.kth.IV1350.dbHandler;

/**
 *Collects all information about an item.  
 */
public class ItemDTO {

	private String name;
	private double price;
	private String itemIdentifier;
	private int quantity;
	
	/**
	 * Creates a package containing information about an item.
	 * 
	 * @param name Name of the item.
	 * @param price Price of one unit of the item.
	 * @param itemIdentifier A string that is unique to the specific type of item. Is used for comparing items
	 * in inventory and sale. 
	 * @param quantity Number of items of the same type, if other than one.
	 */
	public ItemDTO(String name, double price, String itemIdentifier, int quantity) {
		this.name = name;
		this.price = price;
		this.itemIdentifier = itemIdentifier;
		this.quantity = quantity;
	}
	
	/**
	 * @return Name of the specific item.
	 */
	String getName() {
		return this.name;
	}
	
	/**
	 * @return Price of the specific item.
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * @return Identification string of the specific item.
	 */
	public String getID() {
		return this.itemIdentifier;
	}
	
	/**
	 * @return Number of items of the specific type.
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Sets quantity of specific item to value passed as argument. 
	 * @param enteredQuantity Number of items.
	 */
	public void setQuantity(int enteredQuantity) {
		this.quantity = enteredQuantity;
	}
	
	/**
	 * Creates printable string representing the item.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getID() + "\t" + this.getQuantity() + "*" + this.getName() + "\tPPU: " + this.getPrice() + "$");
		return sb.toString();
	}

}
