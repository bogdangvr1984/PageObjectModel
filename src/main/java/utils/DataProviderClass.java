package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="booksNameDataProvider")
	public Object [][] booksNameDataProvider(){
		
		Object[][] data = new Object[5][2];
		
		data[0][0] = "The forest";
		data[0][1] = "book2.jpg";
		
		data[1][0] = "Life in the garden";
		data[1][1] = "book4.jpg";
		
		data[2][0] = "The long road to the deep Silence";
		data[2][1] = "book5.jpg";
		
		data[3][0] = "It’s a really strange story";
		data[3][1] = "book12.jpg";
		
		data[4][0] = "Storm";
		data[4][1] = "books7.jpg";
		
		return data;
	}
	
	@DataProvider(name="cookBooksDataProvider")
    public Object [][] cookBooksDataProvider(){
		
		Object[][] data = new Object[5][2];
		
		data[0][0] = "A hundred and one receipes";
		data[0][1] = "https://keybooks.ro/shop/a-hundred-and-one-receipes/";
		
		data[1][0] = "Cooking with love";
		data[1][1] = "https://keybooks.ro/shop/cooking-with-love/";
		
		data[2][0] = "Healthy Lifestyle";
		data[2][1] = "https://keybooks.ro/shop/healthy-lifestyle/";
		
		data[3][0] = "The Vegan Cookery";
		data[3][1] = "https://keybooks.ro/shop/the-vegan-cookery/";
		
		data[4][0] = "Ultimate book of receipes";
		data[4][1] = "https://keybooks.ro/shop/ultimate-book-of-receipes/";
		
		return data;
	}

}
