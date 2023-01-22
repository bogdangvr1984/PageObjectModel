package utils;

import pages.AudioPostPage;
import pages.ContactsPage;
import pages.EventsPage;
import pages.GenericEventPage;
import pages.MenuPage;
import pages.PostFormatsPage;
import pages.ShopPage;
import pages.TheWickedKingBookPage;

public class BasePage extends BaseTest{
	
	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public ContactsPage contact = new ContactsPage(driver);
	public PostFormatsPage postFormat = new PostFormatsPage(driver);
	public AudioPostPage audioPost = new AudioPostPage(driver);
	public EventsPage events = new EventsPage(driver);
	public GenericEventPage genericEvent = new GenericEventPage(driver);
	public TheWickedKingBookPage wickedKing = new TheWickedKingBookPage(driver);
	

}
