package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseTest;

public class DataProviderLoginTest extends BaseTest {
	
	@DataProvider(name="loginTestData")
	public Object[][] loginTestData(){
		
		Object[][] data = new Object [4][3];
		
		data[0][0] = "TestUser";  data[0][1] = "12345@67890"; data[0][2] = true;
		data[1][0] = "UserGresit";  data[1][1] = "parolaGresita"; data[1][2] = false;
		data[2][0] = "TestUser";  data[2][1] = "12345@67890"; data[2][2] = true;
		data[3][0] = "UserGresit22";  data[3][1] = "parolaGresita22"; data[3][2] = false;
		
		return data;
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username, String password, boolean success) {
		
		menu.click(menu.loginLink);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, password);
		
		if(success) {
			assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginSuccessMsg));
			loginPage.logoutFromApp();
			
		}else if(!success) {
			assertTrue(loginPage.checkElementIsDisplayed(loginPage.loginErrorMsg));
			loginPage.click(loginPage.closePopUp);
			
		}
	}

}
