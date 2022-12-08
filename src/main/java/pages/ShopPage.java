package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers {
	
    public WebDriver driver;
    public Select selectDropdown;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By filterByCookBooks = By.xpath("//a[@href='https://keybooks.ro/product-category/cookbooks/']");
	public By booksOnSale = By.xpath("//span[@class='onsale']");
	public By sliderInitalPosition = By.cssSelector("span[style=\"left: 0%;\"]");
	public By sliderFinalPosition = By.cssSelector("span[style=\"left: 100%;\"]");
	
	public By orderDropDown = By.name("orderby");
	
	public void filterBooks(By locator) {
		driver.findElement(locator).click();
	}
	
	public void onSale() {
		
		//List<WebElement> allBooks = driver.findElements(By.xpath("//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']"));
		//List<WebElement> allBooks = driver.findElements(By.linkText("SALE!"));
		List<WebElement> allBooks = driver.findElements(By.xpath("//span[@class='onsale']"));
		    System.out.println("Number of cookbooks on sale is " + allBooks.size());
		}

	

	
	public void filterByValue(String value) {
		
		WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
		
	}
	
    public void filterByIndex(int index) {
		
		WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
		
	}
    
    public void filterByVisibleText(String text) {
		
		WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
		
	}
    
    public String getCurrentSelectedOption() {
    	WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		return selectDropdown.getFirstSelectedOption().getText();
    }
    
    public void openBook(String text) {
		driver.findElement(By.linkText(text)).click();
	}
}
