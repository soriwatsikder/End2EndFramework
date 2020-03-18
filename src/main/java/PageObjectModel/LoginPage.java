package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
	
	By email = By.cssSelector("#user_email");
	By pass = By.cssSelector("#user_password");
	By login = By.xpath("//input[@name='commit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(pass);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
