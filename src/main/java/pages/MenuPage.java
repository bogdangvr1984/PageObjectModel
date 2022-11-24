package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By contactLink = By.linkText("CONTACTS");
	public By booksLink = By.linkText("BOOKS");
	
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}

}
