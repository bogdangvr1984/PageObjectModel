package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.ShopPage;
import utils.BaseTest;

public class DropDownTest extends BaseTest {
	
	@Test(priority = 1)
	public void selectByValueTest() {
		
		menu.navigateTo(menu.booksLink);
		ShopPage shop = new ShopPage(driver);
		shop.filterByValue("price-desc");
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/?orderby=price-desc");
		assertEquals(shop.getCurrentSelectedOption(), "Sort by price: high to low2");
	}
	
	@Test(priority = 2)
	public void selectByIndexTest() {
		menu.navigateTo(menu.booksLink);
		ShopPage shop = new ShopPage(driver);
		shop.filterByIndex(3);
		assertEquals(shop.getCurrentSelectedOption(), "Sort by latest");
	}
	
	@Test(priority = 3)
	public void selectByVisibleTextTest() {
		menu.navigateTo(menu.booksLink);
		ShopPage shop = new ShopPage(driver);
		shop.filterByVisibleText("Sort by popularity");
		assertEquals(shop.getCurrentSelectedOption(), "Sort by popularity");
	}
	
	@Test(priority = 4)
	public void example() throws InterruptedException {
		menu.navigateTo(menu.booksLink);
		WebElement dropdown = driver.findElement(By.name("orderby"));//incerca in memorie un webelement
		Select select = new Select(dropdown);//primeste webelementul
		select.selectByIndex(2);//se folosests de webelement si face refresh (si se ia alt id de sesiune)
		Thread.sleep(3000);
		select.selectByVisibleText("Sort by popularity");//se foloseste de webelement (crapa cu element is not attached to the page document)
	}

}
