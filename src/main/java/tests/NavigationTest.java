package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MenuPage;
import utils.BaseTest;

public class NavigationTest extends BaseTest{
	
	@Test
	public void naviTest() throws InterruptedException {
		
		MenuPage menuPage = new MenuPage(driver);
		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(menuPage.checkElementIsDisplayed(menuPage.eventsLink));
		menuPage.click(menuPage.eventsLink);
		Thread.sleep(3000);
		sa.assertTrue(menuPage.checkElementIsDisplayed(menuPage.contactLink));
		menuPage.click(menuPage.contactLink);
		Thread.sleep(3000);
		sa.assertTrue(menuPage.checkElementIsDisplayed(menuPage.homeLink));
		menuPage.click(menuPage.homeLink);
		Thread.sleep(3000);
	}

}
