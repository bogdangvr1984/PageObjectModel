package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AccountPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ShippingAddressPage;
import utils.BaseTest;

public class ShippingAddressTest extends BaseTest {
	
	@Test
	public void shippingAddress () throws InterruptedException {
	MenuPage menu = new MenuPage(driver);
	LoginPage loginPage = new LoginPage(driver);
	AccountPage accountPage = new AccountPage(driver);
	ShippingAddressPage shippingAddress = new ShippingAddressPage(driver);
	
	//fac login
	menu.navigateTo(menu.loginLink);
	loginPage.loginInApp("TestUser", "12345@67890");
	
	//dau click pe numele userului logat, ca sa imi apara acel link de settings
	menu.navigateTo(menu.userName);
	
	//fac click pe settings si verific ca imi deschide meniul
	accountPage.navigateTo(accountPage.settingsButton);
	assertTrue(accountPage.checkElementIsDisplayed(accountPage.settingsOpeningMessage));
	
	//accesez Addresses
	accountPage.navigateTo(accountPage.addressesLink);
	
	//accesez Shipping address
	accountPage.navigateTo(accountPage.shippingAddress);
	
	//aleg tara din dropdown si facem assert ca alegerea e corecta
	shippingAddress.selectCountry(41);
	assertEquals(shippingAddress.getCurrentSelectedOption(shippingAddress.countryDropDown), "Canada");
	
	//aleg provincia din dropdown si facem assert ca alegerea e corecta
	shippingAddress.selectProvince("NL");
	assertEquals(shippingAddress.getCurrentSelectedOption(shippingAddress.provinceDropDown), "Newfoundland and Labrador");
	
	Thread.sleep(3000);
	
	}
}
