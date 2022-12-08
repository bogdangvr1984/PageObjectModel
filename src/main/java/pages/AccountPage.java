package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class AccountPage extends SeleniumWrappers{
	
public WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By settingsButton = By.xpath("//a[@href='https://keybooks.ro/wp-admin/profile.php']");
	public By settingsOpeningMessage = By.linkText("edit your password and account details");
	
	public By ordersLink = By.linkText("Orders");
	public By downloadsLink = By.linkText("Downloads");
	public By addressesLink = By.linkText("Addresses");
	
	public By billingAddress = By.xpath("https://keybooks.ro/account/edit-address/billing/");
	public By shippingAddress = By.xpath("//a[@href='https://keybooks.ro/account/edit-address/shipping/']");
    
    public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}

}
