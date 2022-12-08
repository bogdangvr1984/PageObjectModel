package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ShopPage;
import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderCookBooksSearchTest extends BaseTest{
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "cookBooksDataProvider")
	public void searchBooksTest(String bookName, String bookUrl) throws InterruptedException {
		ShopPage shopPage = new ShopPage(driver);
		SoftAssert sa = new SoftAssert();
		
		menu.navigateTo(menu.booksLink);
		shopPage.filterBooks(shopPage.filterByCookBooks);
		shopPage.openBook(bookName);
		
		
		Thread.sleep(3000);
		
		String url = driver.getCurrentUrl();
		sa.assertEquals(url, bookUrl);
		
	}

}
