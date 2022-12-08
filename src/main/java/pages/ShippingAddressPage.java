package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniumWrappers;

public class ShippingAddressPage extends SeleniumWrappers{
	
public WebDriver driver;
	
	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By countryDropDown = By.name("shipping_country");
	public By provinceDropDown = By.name("shipping_state");
	
	public void selectCountry(int index) { 
		WebElement element = driver.findElement(countryDropDown);
		Select selectDropDown = new Select(element);
		selectDropDown.selectByIndex(index);
		
	}
	
	public void selectProvince(String value) { 
		WebElement element = driver.findElement(provinceDropDown);
		Select selectDropDown = new Select(element);
		selectDropDown.selectByValue(value);
		
	}
	
	 public String getCurrentSelectedOption(By locator) {
	    	WebElement element = driver.findElement(locator);
			Select selectDropdown = new Select(element);
			return selectDropdown.getFirstSelectedOption().getText();
	    }
			
    

}
