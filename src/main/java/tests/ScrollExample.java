package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Log;

public class ScrollExample  extends BaseTest {
	
	
	//@Test
	public void jsExecutorScroll() throws InterruptedException {
		
		//js executor scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("window.scrollBy(0, 2000)");
		
		Thread.sleep(3000);
		//action class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
		
		Thread.sleep(3000);
		
	}
	
	//@Test
	public void scrollToElement() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		
		WebElement signUpButton = driver.findElement(By.xpath("//input[@value='Sign up']"));
		
		//jse.executeScript("arguments[0].scrollIntoView();", signUpButton);
		//Thread.sleep(3000);
		
		action.moveToElement(signUpButton).perform();
		Thread.sleep(3000);
	}
	
	@Test
	public void scrollTopAndDown() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Log.info("Test log!!!");
		
		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		
		//scroll top
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
	}

}
