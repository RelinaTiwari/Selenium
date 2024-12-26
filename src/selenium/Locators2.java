package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		String name = "Relina";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getpassword(driver);
		Thread.sleep(1000);
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/p")).getText());
		//driver.close();
		Assert.assertEquals((driver.findElement(By.xpath("//div/p")).getText()), "You are successfully logged in.");
		driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello Relina,");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		

	}
	public static String getpassword(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		String password = driver.findElement(By.cssSelector("form p")).getText();
		String[] pass1 = password.split("'");
		for(String x : pass1)
		{
			System.out.println(x);
		}
		String[] pass2 = pass1[1].split("'");
		return pass2[0];
		
		
	}



}
