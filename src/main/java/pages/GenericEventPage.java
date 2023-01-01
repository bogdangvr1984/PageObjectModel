package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class GenericEventPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public GenericEventPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By mapLink = By.partialLinkText("map");
	public By iframe = By.tagName("iframe");
	
	public void clickMap() {
		driver.switchTo().frame(getWebElement(iframe));
		click(mapLink);
	}

}
