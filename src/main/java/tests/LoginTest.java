package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test(priority = 1)
	public void validloginTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		loginPage.loginInApp("TestUser", "12345@67890");
		
		assertTrue(loginPage.checkMsgIsDisplayed(loginPage.loginSuccessMsg));
		
		loginPage.logoutFromApp();
	}
	
	@Test(priority = 2)
	public void invalidLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		loginPage.loginInApp("TestUser", "1234");
		
		assertTrue(loginPage.checkMsgIsDisplayed(loginPage.loginErrorMsg));
		
	}

}
