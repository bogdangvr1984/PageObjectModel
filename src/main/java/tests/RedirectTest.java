package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class RedirectTest extends BaseTest {
	
	@Test
	public void socialMediaRedirect() throws InterruptedException {

		         SoftAssert sa = new SoftAssert();

		         sa.assertTrue(redirectTabs(menu.facebook, "https://www.facebook.com/keytraining.ro"));

		         sa.assertTrue(redirectTabs(menu.twitter, "https://twitter.com/"));

		         sa.assertTrue(redirectTabs(menu.instagram, "https://www.instagram.com/"));

		         sa.assertAll();

		    }

	public Boolean redirectTabs(By locator, String checkedUrl) {

        menu.click(locator);

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(browserTabs.get(1));

        String currentURl  = driver.getCurrentUrl();

        driver.close();

        driver.switchTo().window(browserTabs.get(0));

        if(currentURl.equals(checkedUrl)) {

            return true;

        }else {

            return false;

        }
   }
}
