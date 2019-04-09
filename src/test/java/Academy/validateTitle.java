package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class validateTitle extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");

	}

	@Test

	public void validateTitle() throws IOException, InterruptedException {
		Thread.sleep(3000);
		LandingPage lp = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully verified Text message");

	}

	@AfterTest

	public void tearDown() {
		driver.close();
		driver=null;
	}

}
