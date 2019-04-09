package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider="getData")

	public void basePageNavigation(String username, String password, String text) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		LandingPage lp = new LandingPage(driver);

		lp.getLogin().click();

		LoginPage login=new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLogin().click();
		log.info(text);

	}


	@DataProvider
	public Object[][] getData() {
		// Row indicates how many different data types test should run for each set of data
		// column indicates how many set of data to be run for each test
		// Give the below data to Test
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";

		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="123456";
		data[1][2]="Non restricted User";

		return data;

	}

	@AfterTest

	public void tearDown() {
		driver.close();
		
		// Assign it to null to avoid increase of memory when more no of tests keep initializing driver , so that once each test is completed ,it can be 
		// assigned to null since each test is initializing driver object anywayz.
		driver=null;
	}

}
