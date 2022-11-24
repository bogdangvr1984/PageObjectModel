package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submitButton = By.xpath("//input[@class='submit_button']");
	
	public By loginErrorMsg = By.cssSelector("div[class*='sc_infobox_style_error']");
	public By loginSuccessMsg = By.cssSelector("div[class*='sc_infobox_style_success']");
	
	public By logoutButton = By.cssSelector("li[class='menu_user_logout']");
	
	public void loginInApp(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(submitButton).click();
	}
	
	public boolean checkMsgIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
		
	}
	
	public void logoutFromApp() {
		
		driver.findElement(logoutButton).click();
	}
	

}
