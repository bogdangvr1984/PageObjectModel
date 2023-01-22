package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class TheWickedKingBookPage extends SeleniumWrappers{
	
public WebDriver driver;
	
	public TheWickedKingBookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By category = By.xpath("//span[@class='posted_in']//a[@href='https://keybooks.ro/product-category/new-releases/']");
	public By productID = By.xpath("//span[@class='product_id']/span");
	
	public By kingPicture1 = By.xpath("//figure[@class='woocommerce-product-gallery__wrapper']//a[@href='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing1.png']");
	public By kingPicture2 = By.xpath("//figure[@class='woocommerce-product-gallery__wrapper']//a[@href='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing2.png']");
	public By kingPicture3 = By.xpath("//figure[@class='woocommerce-product-gallery__wrapper']//a[@href='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing3.png']");
	public By kingPicture4 = By.xpath("//figure[@class='woocommerce-product-gallery__wrapper']//a[@href='https://keybooks.ro/wp-content/uploads/2022/11/TheWickedKing4.png']");
	
	public String getElementAttribute(By locator) {
		
		return driver.findElement(locator).getAttribute("href");
	}
	
	public String verifyCategory() {

		String categ = driver.findElement(category).getText();
		
		return categ;	
	}
	
	public int verifyProductID() {

		String id = driver.findElement(productID).getText();
		
		return Integer.parseInt(id);
	}
	

}
