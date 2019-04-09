package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	// make this static driver so that another class object caanot modify it .Also, it can be used in other classes without creating driver oject
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kbanu\\eclipse-workspace\\E2EProject\\src\\test\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(browserName.equals("mozilla")) {
			driver = new FirefoxDriver();

		}
		else {


		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// return the webdriver
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Users\\kbanu\\eclipse-workspace\\ScreenShot\\"+result+"Test.png"));

	}

}
