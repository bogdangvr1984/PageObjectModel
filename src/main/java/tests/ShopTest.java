package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class ShopTest extends BaseTest {
	
	@Test
	public void testShop() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		ShopPage shopPage = new ShopPage(driver);
		
		menu.navigateTo(menu.booksLink);
		shopPage.filterBooks();
		
//		assertTrue(shopPage.onSale(shopPage.booksOnSale));
		
		Thread.sleep(3000);
	}

}