package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import utils.BaseTest;

public class JavascriptExecutorTest extends BaseTest {
	
	//@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//driver.get(null);
		//driver.navigate().to(null);
		jse.executeScript("window.location='https://emag.ro'");
		
		//driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
		
		//driver.navigate().forward();
		jse.executeScript("window.history.forward(-1)");
		
		//How to refresh a webpage in multiple ways
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//4
		driver.get(driver.getCurrentUrl());
	}
	
	@Test
	public void example2() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//alternativa pentru click
		//jse.executeScript("arguments[0].click()", app.menu.getWebElement(app.menu.searchIcon));
		//alternativa pentru sendKeys
		//jse.executeScript("arguments[0].value='cooking'", app.menu.getWebElement(app.menu.searchInput));
		//alternativa pentru click
		//jse.executeScript("arguments[0].click()", app.menu.getWebElement(app.menu.searchIcon));
		
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		
		//alternativa pentru isDisplayed
		jse.executeScript("document.getElementsByClassName('post_title')[0].checkVisibility()");
		
		//alternativa pentru getText
		String bookTitle = jse.executeScript("document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
		System.out.println(bookTitle);
		
		//alternativa pentru getTitle
		String pageTitle = jse.executeScript("return document.title").toString();
		System.out.println(pageTitle);
		
		//alternativa pentru getCurrentURL
		String currentURL = jse.executeScript("return document.URL").toString();
		System.out.println(currentURL);
		
		
		Thread.sleep(5000);
		
		//jse.executeScript("arguments[0].click();", null)
		
	}
	
	@Test
	public void example3() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		System.out.println(driver.getTitle());
		
		//jse.executeScript(
				
		System.out.println(driver.getTitle());
		
	}
	

}
