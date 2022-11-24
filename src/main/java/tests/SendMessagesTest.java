package tests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import utils.BaseTest;

/*
 * AC : 4 fields(name, email, subject, message) din care 3 mandatory(name, email, message) si 1 optional (subject)
 * 
 * 1. Send success message (All fields completed) --> Expect message: Thank you for your message. It has been sent.
 * 2. Send message without name field --> Expect message: The field is required
 * 3. Send message without email field --> Expect message: The field is required
 * 4. Send message without message field --> Expect message: The field is required
 * 5. Send message without subject field --> Expect message : Thank you for your message. It has been sent.
 * 
 * 
 * 
 * 
 */

public class SendMessagesTest extends BaseTest {
	
	@Test(priority = 1)
	
	public void sendSuccessMessageTest() {
		
		MenuPage menu = new MenuPage(driver);
		//ContactsPage contactPage = new ContactsPage(driver);
		//menu.navigateTo(menu.contactLink);
		ContactsPage contactPage = menu.navigateToContact();
		contactPage.sendMessage("Test", "email@email.test", "My subject", "My message");
		assertTrue(contactPage.getMessage(contactPage.messageSentMsg, "Thank you for your message. It has been sent."));
		
	}
	
	@Test(priority = 2)
	
	public void sendMessageWithoutNameTest() {
		
		MenuPage menu = new MenuPage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		
		menu.navigateTo(menu.contactLink);
		contactPage.sendMessage("", "email@email.test", "My subject", "My message");
		
		assertTrue(contactPage.getMessage(contactPage.emptyFieldMsg, "The field is required."));
		
	}
	
   @Test(priority = 3)
	
	public void sendMessageWithoutEmailTest() {
		
		MenuPage menu = new MenuPage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		
		menu.navigateTo(menu.contactLink);
		contactPage.sendMessage("Test", "", "My subject", "My message");
		
		assertTrue(contactPage.getMessage(contactPage.emptyFieldMsg, "The field is required."));
		assertTrue(contactPage.getMessage(contactPage.messageSentMsg, "One or more fields have an error. Please check and try again."));
   }
   
   @Test(priority = 4)
	
	public void sendMessageWithoutMessageFieldTest() {
		
		MenuPage menu = new MenuPage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		
		menu.navigateTo(menu.contactLink);
		contactPage.sendMessage("Test", "test@test.com", "My subject", "");
		
		assertTrue(contactPage.getMessage(contactPage.emptyFieldMsg, "The field is required."));
		assertTrue(contactPage.getMessage(contactPage.messageSentMsg, "One or more fields have an error. Please check and try again."));
		
  }
   
   @Test(priority = 5)
	
	public void sendMessageWithoutSubjectFieldTest() {
		
		MenuPage menu = new MenuPage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		
		menu.navigateTo(menu.contactLink);
		contactPage.sendMessage("Test", "email@email.test", "", "My message");
		
		assertTrue(contactPage.getMessage(contactPage.messageSentMsg, "Thank you for your message. It has been sent."));
		
 }
   
   
   
}
