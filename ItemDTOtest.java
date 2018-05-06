package se.kth.IV1350.dbHandler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemDTOtest {

	@Test
	void toStringtest() {
		ItemDTO item = new ItemDTO("banana", 1.50, "12345", 4);
		String expected = "12345	4*banana	PPU: 1.5$";
		String result = item.toString();
		assertEquals(expected, result);
	}

}
