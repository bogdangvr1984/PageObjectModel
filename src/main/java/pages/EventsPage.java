package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class EventsPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public EventsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By festivalOfOldFilmsLink = By.linkText("Festival of Old Films");

}
