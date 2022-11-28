package utils;

import pages.MenuPage;
import pages.ShopPage;

public class BasePage extends BaseTest{
	
	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);

}
