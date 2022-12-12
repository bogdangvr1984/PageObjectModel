package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassExamples extends BaseTest {
	
	
	//@Test
	public void hoverTest() throws InterruptedException {
		
		app.menu.hoverElement(app.menu.blogLink);
		Thread.sleep(3000);
		app.menu.hoverElement(app.menu.aboutLink);
		Thread.sleep(3000);
		app.menu.hoverElement(app.menu.blogLink);
		app.menu.hoverElement(app.menu.blogSubMenuMasonry);
		//app.menu.hoverElement(app.menu.blogSubMenuMasonrysubMenu2);
		app.menu.click(app.menu.blogSubMenuMasonrysubMenu2);
		Thread.sleep(3000);
	}
	
	//@Test
	public void dragAndDropTest() throws InterruptedException {
		
		app.menu.navigateTo(app.menu.shopLink);
		app.shop.dragAndDrop(app.shop.sliderInitalPosition, 100, 0);
		app.shop.dragAndDrop(app.shop.sliderFinalPosition, -100, 0);
		Thread.sleep(3000);
	}
	
	//@Test
	public void sendKeysExample() throws InterruptedException {
		
		app.menu.hoverElement(app.menu.blogLink);
		app.menu.click(app.menu.blogSubMenuPostFormats);
		
	//	WebElement searchElement = driver.findElement(app.postFormat.searchField);			
		
		Actions action = new Actions(driver);
		action
		      .moveToElement(app.postFormat.getWebElement(app.postFormat.searchField))
		      .keyDown(Keys.SHIFT)
		      .sendKeys(app.postFormat.getWebElement(app.postFormat.searchField), "abracadabra")
		      .perform();
		
		Thread.sleep(3000);
	}
	
	//@Test
	public void sendKeysExample2() throws InterruptedException {
		app.menu.navigateTo(app.menu.contactLink);
		
		Actions action = new Actions(driver);
		action
		     .moveToElement(app.contact.getWebElement(app.contact.nameField))
		     .sendKeys(app.contact.getWebElement(app.contact.nameField), "Name")
		     .sendKeys(Keys.TAB, "emai@email.com")
		     .sendKeys(Keys.TAB, "My subject")
		     .sendKeys(Keys.TAB, "My message")
		     .sendKeys(Keys.TAB, Keys.ENTER)
		     .perform();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void sendKeysExample3() throws InterruptedException {
		app.menu.navigateTo(app.menu.contactLink);
		Thread.sleep(5000);
		
		int getX = app.contact.getWebElement(app.contact.nameField).getLocation().getX();
		int getY = app.contact.getWebElement(app.contact.nameField).getLocation().getY();
		
		Actions action = new Actions(driver);
		action
		     .moveByOffset(getX, getY)
		     .click()
		     .sendKeys("Name")
		     .sendKeys(Keys.TAB, "emai@email.com")
		     .sendKeys(Keys.TAB, "My subject")
		     .sendKeys(Keys.TAB, "My message")
		     .sendKeys(Keys.TAB, Keys.ENTER)
		     .perform();
		
		Thread.sleep(2000);
	}
 
}
