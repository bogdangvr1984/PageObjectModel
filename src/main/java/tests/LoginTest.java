package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority = 1, groups = "LoginFunctionality")
	public void validLoginTest(String username, String password) throws InterruptedException {
		
		MenuPage menu =  new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		menu.navigateTo(menu.loginLink);
		loginPage.loginInApp(username, password);
		
		assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
		
		loginPage.logoutFromApp();
	}
	
	@Parameters({"invalidUser", "invalidPass"})
	@Test(priority = 2, groups = "LoginFunctionality")
	public void invalidLoginTest(String wrongUser, String wrongPass) {
		MenuPage menu =  new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		loginPage.loginInApp(wrongUser, wrongPass);
		
		assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));

	}
	

}