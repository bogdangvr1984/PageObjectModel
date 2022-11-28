package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {
	
    public WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By searchWidget = By.xpath("//input[@class='search_field' and @title='Search for:']");
	public By searchButton = By .xpath("//form[@role='search']/button[@class='search_button icon-search']");
	public By blogPostOpen = By.xpath("(//h4[@class='post_title']/a[@href='https://keybooks.ro/2016/02/02/why-i-wont-stop-buying-books/'])[1]");
	public By checkInClassic = By.xpath("//a[@class='category_link' and @href='https://keybooks.ro/category/classic/']");
	public By checkInNews = By.xpath("//a[@class='category_link' and @href='https://keybooks.ro/category/news/']");
	public By checkInRecommend = By.xpath("//a[@class='category_link' and @href='https://keybooks.ro/category/recommend/']");
	
	
	public void searchBlogPost(String searchPhrase) {
		driver.findElement(searchWidget).sendKeys(searchPhrase);
		driver.findElement(searchButton).click();
		driver.findElement(blogPostOpen).click();
	}
	
    public boolean checkCategoriesAreDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
		
	}
	

}
