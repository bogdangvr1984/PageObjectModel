package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.TheWickedKingBookPage;
import utils.BaseTest;

public class TestHomework29 extends BaseTest {
	
	
@Test
public void homeWork29() {
	
	menu.navigateTo(menu.searchIcon);
	menu.sendKeys(menu.searchInput, "king");
	menu.navigateTo(menu.searchKing);
	
	assertEquals(app.wickedKing.verifyCategory(), "New releases");
	assertEquals(app.wickedKing.verifyProductID(), 1709);
	
	String[] pictures = new String[4];
	pictures[0] = app.wickedKing.getElementAttribute(app.wickedKing.kingPicture1);
	pictures[1] = app.wickedKing.getElementAttribute(app.wickedKing.kingPicture2);
	pictures[2] = app.wickedKing.getElementAttribute(app.wickedKing.kingPicture3);
	pictures[3] = app.wickedKing.getElementAttribute(app.wickedKing.kingPicture4);
	
	for(int i=0; i<pictures.length; i++) {
		assertTrue(pictures[i].contains("TheWickedKing"+ (i+1) +".png"));
	}
	
	
}
	

}
