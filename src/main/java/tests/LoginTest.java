package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		loginPage.loginInApp("TestUser", "12345@67890");
	}

}
