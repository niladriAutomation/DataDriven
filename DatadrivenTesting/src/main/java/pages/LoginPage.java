package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	By uname = By.name("userName");
	By passwd = By.name("password");
	By submit = By.xpath("//input[@name='submit']");

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;


	}
	public WebElement enterUserName() {
		return driver.findElement(uname);
		
	}
	public WebElement enterPassword() {
		return driver.findElement(passwd);
		
	}
	public WebElement clickSubmit() {
		return driver.findElement(submit);
		
	}

}
