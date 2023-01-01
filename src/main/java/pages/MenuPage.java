package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By contactLink = By.linkText("CONTACTS");
	public By shopLink = By.linkText("BOOKS");
	public By blogLink = By.linkText("BLOG");
	//public By shopLink = By.linkText("BOOKS");
	public By classicLink = By.xpath("//li[@id='menu-item-114']/a[@href='https://keybooks.ro/category/classic/']");
	public By homeLink = By.linkText("HOME");
	public By eventsLink = By.linkText("EVENTS");
	public By aboutLink = By.linkText("ABOUT");
	public By blogSubMenuMasonry = By.xpath("//a[contains(text(), \"Masonry\")]");
	public By blogSubMenuMasonrysubMenu2 = By.xpath("//a[contains(text(), \"Masonry 2\")]");
	public By blogSubMenuPostFormats = By.linkText("Post Formats");
	
	public By searchIcon = By.cssSelector("button[class*='search_submit']");
	public By searchInput = By.cssSelector("input[class='search_field']");
	
	public By facebook = By.xpath("//div[@class='top_panel_top_user_area']//a[@href='https://www.facebook.com/keytraining.ro']");
	public By twitter = By.xpath("//div[@class='top_panel_top_user_area']//a[@href='https://twitter.com/']");
	public By instagram = By.xpath("//div[@class='top_panel_top_user_area']//a[@href='https://www.instagram.com']");
	
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
