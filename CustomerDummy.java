package se.kth.IV1350.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the goods brought to pos and amount paid. Used instead of hard coded value calls to controller. 
 */
class CustomerDummy {
	
	List<ShoppingCartItem> shoppingCart = new ArrayList<ShoppingCartItem>();
	private double amountPaid;
	
	/**
	 * Creates instance of {@link CustomerDummy} with preset goods to by, and paid amount.
	 */
	CustomerDummy() {
		
		this.shoppingCart.add(new ShoppingCartItem("12345", 2));
		this.shoppingCart.add(new ShoppingCartItem("12346", 1));
		this.shoppingCart.add(new ShoppingCartItem("12346", 2));
		this.shoppingCart.add(new ShoppingCartItem("12347", 1));
		this.shoppingCart.add(new ShoppingCartItem("12345", 4));
		this.amountPaid = 50;
	}
	
	/**
	 * @return list of items that is to be bought.
	 */
	List<ShoppingCartItem> getShoppingCart(){
		return this.shoppingCart;
	}
	
	/**
	 * @return Amount of money that is paid in sale transaction.
	 */
	double getAmountPaid() {
		return this.amountPaid;
	}

}
