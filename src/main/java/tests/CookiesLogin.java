package tests;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class CookiesLogin extends BaseTest {
	
	Set<Cookie> cookies;
	
	@Test(priority = 1)
	public void validloginTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		menu.navigateTo(menu.loginLink);
		loginPage.loginInApp("TestUser", "12345@67890");
		
		assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
		
		cookies = driver.manage().getCookies();
		System.out.println(cookies);
	}
	
	@Test(priority = 2)
	public void cookiesLogin() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		for(Cookie cook : cookies) {
			
			driver.manage().addCookie(cook);
		}
		
		Thread.sleep(3000);
		menu.navigateTo(menu.shopLink);
	}

}
