package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By singin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.cssSelector(".text-center>h2");
	By navBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(singin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
