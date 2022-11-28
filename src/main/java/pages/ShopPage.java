package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	
    public WebDriver driver;
    public Select selectDropdown;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By filterByCookBooks = By.xpath("//a[@href='https://keybooks.ro/product-category/cookbooks/']");
	public By booksOnSale = By.xpath("//span[@class='onsale']");
	
	public By orderDropDown = By.name("orderby");
	
	public void filterBooks() {
		driver.findElement(filterByCookBooks).click();
	}
	
	/*	public boolean onSale(By locator) {
		
		List<ShopPage> books = webDriver.findElements(By.xpath("//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']"));
		for(ShopPage booksOnSale : books){
		    if(books.equals(booksOnSale)){
		        return books;
		    }
		    else{
		        return null;
		    }
		}
		
		return driver.findElement(locator).isDisplayed();
	}
*/
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
}
