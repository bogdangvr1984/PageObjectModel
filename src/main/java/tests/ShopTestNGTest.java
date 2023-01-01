package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import utils.BaseTest;

public class ShopTestNGTest extends BaseTest {
	
	@Test
	public void lowToHigh() throws InterruptedException {
		
		menu.navigateTo(menu.shopLink);
		shop.filterByValue("price");

		assertEquals(shop.getCurrentSelectedOption(), "Sort by price: low to high");
		
		assertTrue(shop.sortLowToHigh());
		
		Thread.sleep(3000);
	}

}
