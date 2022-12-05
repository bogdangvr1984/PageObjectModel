package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest{
	
	//WebElement element = driver.findElement(locator);
	//element.click();
	
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
			element.click();
			
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
			
		}
	}
	
	public void waitForElementToBeClickable(By locator) {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
			
		}
	}
	
	public void waitForElementToBeVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}catch(NoSuchElementException e) {
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
			element.clear();
			element.sendKeys(textToBeSend);
			
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
		
		
	}

}
