package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriver driver = new ChromeDriver();
		
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
