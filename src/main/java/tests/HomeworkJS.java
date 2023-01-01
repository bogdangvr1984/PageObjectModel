package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class HomeworkJS extends BaseTest {
	
	@Test
	public void homeworkJS() throws InterruptedException {
		
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	String javaScriptHover = "var objObject = document.createEvent('MouseEvents');" 
			+ "objObject.initMouseEvent('mouseover',true);" 
			+ "arguments[0].dispatchEvent(objObject);";
	
	jse.executeScript(javaScriptHover, app.menu.getWebElement(app.menu.blogLink));

	jse.executeScript("document.getElementById('menu-item-232').childNodes[0].click()");
	
	WebElement galleryFormat = driver.findElement(By.linkText("Gallery Format"));
    jse.executeScript("arguments[0].scrollIntoView();", galleryFormat);
    
    jse.executeScript("document.getElementsByClassName('post_title')[4].childNodes[0].click()");
    
    WebElement addComment = driver.findElement(By.xpath("//h2[@class='section_title comments_form_title']"));
    jse.executeScript("arguments[0].scrollIntoView();", addComment);
    
    jse.executeScript("document.getElementById('comment').value='homework 28'");
    jse.executeScript("document.getElementById('author').value='Bogdan'");
    jse.executeScript("document.getElementById('email').value='test@big.com'");
    jse.executeScript("document.getElementById('url').value='https://testng.org/doc/'");
    Thread.sleep(3000);
    jse.executeScript("document.getElementById('send_comment').click()");
    
	}

}
