package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static  WebDriver initializeBrowser() {
		System.setProperty("webdriver.chrome.driver","/Users/niladridas/Downloads/chromedriver");
		WebDriver driver  = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
		
		
	}

}
