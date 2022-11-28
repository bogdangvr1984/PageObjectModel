package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class BlogTest extends BaseTest{
	
	@Test
	public void testBlog() throws InterruptedException {

		MenuPage menu = new MenuPage(driver);
		BlogPage blogPage = new BlogPage(driver);
		
		menu.navigateTo(menu.blogLink);
		menu.navigateTo(menu.classicLink);
		blogPage.searchBlogPost("Why I won't stop buying books");
		
		assertTrue(blogPage.checkCategoriesAreDisplayed(blogPage.checkInClassic));
		assertTrue(blogPage.checkCategoriesAreDisplayed(blogPage.checkInNews));
		assertTrue(blogPage.checkCategoriesAreDisplayed(blogPage.checkInRecommend));

		
		Thread.sleep(3000);
	}

}
