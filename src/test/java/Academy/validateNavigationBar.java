package Academy;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class validateNavigationBar extends base {

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test

	public void validateAppNavBar() throws IOException, InterruptedException {
		Thread.sleep(3000);
		LandingPage lp = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertTrue(lp.getNavigationbar().isDisplayed(), "FEATURED COURSES");
	}

	@AfterTest

	public void tearDown() {
		driver.close();
		driver=null;
	}

}



