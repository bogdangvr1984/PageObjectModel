package utils;

import pages.ContactsPage;
import pages.MenuPage;
import pages.PostFormatsPage;
import pages.ShopPage;

public class BasePage extends BaseTest{
	
	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public ContactsPage contact = new ContactsPage(driver);
	public PostFormatsPage postFormat = new PostFormatsPage(driver);

}
