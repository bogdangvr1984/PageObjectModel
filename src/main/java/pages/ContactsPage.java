package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class ContactsPage extends SeleniumWrappers{
	
	public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	public By nameField = By.cssSelector("input[name='your-name']");
	public By emailField = By.cssSelector("input[name='your-email']");
	public By subjectField = By.cssSelector("input[name='your-s']");
	public By messageField = By.cssSelector("input[name='your-message']");
	public By submitButton = By.cssSelector("input[value='Send Message']");
	
	public By messageSentMsg = By.cssSelector("div[class='wpcf7-response-output']");
	public By emptyFieldMsg = By.cssSelector("span[class='wpcf7-not-valid-tip']");
	
	
	public void sendMessage(String name, String email, String subject, String message) {
		
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(subjectField).sendKeys(subject);
		driver.findElement(messageField).sendKeys(message);
		driver.findElement(submitButton).click();
	}
	

	public boolean getMessage(By locator, String textToBePresent) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, textToBePresent));
		return true;
		}catch(NoSuchElementException e) {
			return false;
		}
		
	}

	
}
