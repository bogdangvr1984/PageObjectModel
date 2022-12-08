package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By contactLink = By.linkText("CONTACTS");
	public By booksLink = By.linkText("BOOKS");
	public By blogLink = By.linkText("BLOG");
	public By classicLink = By.xpath("//li[@id='menu-item-114']/a[@href='https://keybooks.ro/category/classic/']");
	public By homeLink = By.linkText("HOME");
	public By eventsLink = By.linkText("EVENTS");
	
	public By searchIcon = By.cssSelector("button[class*='search_submit']");
	public By searchInput = By.cssSelector("input[class='search_field']");
	
	public By userName = By.xpath("//span[@class='user_name']");
	
	public void search(String text) {
		
		click(searchIcon);
		sendKeys(searchInput, text);
		click(searchIcon);
	}
	
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	public ContactsPage navigateToContact() {
		driver.findElement(contactLink).click();
		return new ContactsPage(driver);
	}
	
	public BlogPage navigateToClassic() {
		driver.findElement(classicLink).click();
		return new BlogPage(driver);
	}
	

}
