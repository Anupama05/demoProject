package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	
	public WebDriver driver;
	
	
	By signin = By.cssSelector("a[href*='sign_in']");
	//xpath 
	//By title = By.xpath("//div[@class='text-center']/h2");
	By title = By.cssSelector(".text-center>h2");
	By navigation = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
		
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
		
	}
	
	public WebElement getNavigationbar() {
		return driver.findElement(navigation);
		
	}
}

