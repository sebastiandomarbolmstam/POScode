package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import se.kth.IV1350.dbHandler.ItemDTO;

class CompleteSaleTest {
	double runningTotal = 0;

	@Test
	void changeAssembleInformationTest() {
		CompleteSale compSale = new CompleteSale();
		Sale sale = new Sale();
		ItemDTO itemOne = new ItemDTO("banana", 1.5, "12345", 2);
		ItemDTO itemTwo = new ItemDTO("Strawberrys", 4.5, "12346", 1);
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		list.add(itemOne);
		list.add(itemTwo);
		double paidAmount = 50;
		
		for(ItemDTO item : list) {
			runningTotal += item.getPrice()*item.getQuantity();
		}
		
		double totalWithTaxes = runningTotal*1.10;
		SaleDTO saleDTO = new SaleDTO(itemTwo, list, runningTotal, sale.getTime());
		double expected = 50 - totalWithTaxes;
		EndOfSaleDTO resultingDTO = compSale.assembleSaleInformation(saleDTO, paidAmount);
		double result = resultingDTO.getChange();
		assertEquals(expected, result);
	}
	
	@Test
	void totalWithTaxesCompleteSaleTest() {
		CompleteSale compSale = new CompleteSale();
		Sale sale = new Sale();
		ItemDTO itemOne = new ItemDTO("banana", 1.5, "12345", 2);
		ItemDTO itemTwo = new ItemDTO("Strawberrys", 4.5, "12346", 1);
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		list.add(itemOne);
		list.add(itemTwo);
		double paidAmount = 50;
		double runningTotal = 7.5;
		SaleDTO saleDTO = new SaleDTO(itemTwo, list, runningTotal, sale.getTime());
		EndOfSaleDTO resultingDTO = compSale.assembleSaleInformation(saleDTO, paidAmount);
		double expected = runningTotal*1.10;
		double result = resultingDTO.getTotalWithTaxes();
		assertEquals(expected, result);
	}
	
	@Test
	void negativeAmountCompleteSaleTest() {
		CompleteSale compSale = new CompleteSale();
		Sale sale = new Sale();
		ItemDTO itemOne = new ItemDTO("banana", 1.5, "12345", 2);
		ItemDTO itemTwo = new ItemDTO("Strawberrys", 4.5, "12346", 1);
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		list.add(itemOne);
		list.add(itemTwo);
		double paidAmount = -50;
		double runningTotal = 7.5;
		SaleDTO saleDTO = new SaleDTO(itemTwo, list, runningTotal, sale.getTime());
		EndOfSaleDTO resultingDTO = compSale.assembleSaleInformation(saleDTO, paidAmount);
		double expected = -50 - 7.5*1.10;
		double result = resultingDTO.getChange();
		assertEquals(expected, result);
	}

}
