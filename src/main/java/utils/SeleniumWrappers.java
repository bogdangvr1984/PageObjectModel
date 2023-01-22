package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest{
	
	//WebElement element = driver.findElement(locator);
	//element.click();
	
	public WebElement getWebElement(By locator) {
		waitForElementToBeVisible(locator);
		return driver.findElement(locator);
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		try {
			getWebElement(locator);
			//WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.dragAndDropBy(getWebElement(locator), x, y).perform();
			//action.clickAndHold(element).moveByOffset(x, y).release().perform();
					
		}catch(NoSuchElementException e) {
			new TestException(e.getMessage());
		}
	}
	
	public void hoverElement(By locator) {
		try {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		}catch(NoSuchElementException e) {
			 new TestException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * Custom click method, that waits for element to be clickable before triggering click
	 * @param locator --> webelement locator
	 */
	
	public void click(By locator) {
		
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.elementToBeClickable(locator));
			
			waitForElementToBeClickable(locator);
			WebElement element = driver.findElement(locator);
			Log.info("called method <Click()> on element :" + element.getAttribute("outerHTML"));
			element.click();
			//getWebElement(locator).click();
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <Click> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
			
		}
	}
	
	public void waitForElementToBeClickable(By locator) {
		
		try {
			Log.info("Called method <waitForElementToBeClickable> on element with locator :" + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToBeClickable> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
			
		}
	}
	
	public void waitForElementToBeVisible(By locator) {
		try {
			Log.info("Called method <waitForElementToBeVisible> on element with locator :" + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToBeVisible> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public boolean checkElementIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
		
	}
	
	public void sendKeys(By locator, String textToBeSend) {
		try {
			waitForElementToBeVisible(locator);
			WebElement element = driver.findElement(locator);
			Log.info("called clear on method<sendKeys> on element " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("called sendKeys on method<sendKeys> on element " + element.getAttribute("outerHTML"));
			element.sendKeys(textToBeSend);
			
		}catch(NoSuchElementException e) {
			Log.error("Failed method <sendKeys> with error " + e.getMessage());
			throw new TestException(e.getMessage());
		}
		
		
	}

}
