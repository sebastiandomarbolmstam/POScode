package se.kth.IV1350.dbHandler;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemInventoryTest {

	@Test
	void nameTest() {
		ItemInventory inventory = new ItemInventory();
		String identifier = "12345";
		int quantity = 3;
		ItemDTO item = inventory.findItemDTO(identifier, quantity);
		String expected = "banana";
		String result = item.getName();
		assertEquals(expected, result);
	}
	
	@Test
	void priceTest() {
		ItemInventory inventory = new ItemInventory();
		String identifier = "12345";
		int quantity = 3;
		ItemDTO item = inventory.findItemDTO(identifier, quantity);
		double expected = 1.50;
		double result = item.getPrice();
		assertEquals(expected, result);
	}
	
	@Test
	void identifierTest() {
		ItemInventory inventory = new ItemInventory();
		String identifier = "12345";
		int quantity = 3;
		ItemDTO item = inventory.findItemDTO(identifier, quantity);
		String expected = "12345";
		String result = item.getID();
		assertEquals(expected, result);
	}
	
	@Test
	void quantityTest() {
		ItemInventory inventory = new ItemInventory();
		String identifier = "12345";
		int quantity = 3;
		ItemDTO item = inventory.findItemDTO(identifier, quantity);
		int expected = 3;
		int result = item.getQuantity();
		assertEquals(expected, result);
	}
	
	@Test
	void noMatchTest() {
		ItemInventory inventory = new ItemInventory();
		String identifier = "12348";
		int quantity = 3;
		ItemDTO expected = null;
		ItemDTO result = inventory.findItemDTO(identifier, quantity);
		assertEquals(expected, result);
	}
	
	@Test
	void nullStringTest() {
		ItemInventory inventory = new ItemInventory();
		String identifier = null;
		int quantity = 3;
		ItemDTO expected = null;
		ItemDTO result = inventory.findItemDTO(identifier, quantity);
		assertEquals(expected, result);
	}
	
	@Test 
	void bigIntTest (){
		ItemInventory inventory = new ItemInventory();
		String identifier = "12345";
		int quantity = Integer.MAX_VALUE;
		ItemDTO item = inventory.findItemDTO(identifier, quantity);
		int expected = Integer.MAX_VALUE;
		int result = item.getQuantity();
		assertEquals(expected, result);
	}
	
	@Test 
	void smallIntTest (){
		ItemInventory inventory = new ItemInventory();
		String identifier = "12345";
		int quantity = Integer.MIN_VALUE;
		ItemDTO item = inventory.findItemDTO(identifier, quantity);
		int expected = Integer.MIN_VALUE;
		int result = item.getQuantity();
		assertEquals(expected, result);
	}

}
