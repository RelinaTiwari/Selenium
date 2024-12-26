package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DriverIssue {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		List<WebElement> link=driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
		String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		for(WebElement links:link)
		{
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("Head");
			conn.connect();
			int resp=conn.getResponseCode();
			
		if(resp>400)
		{
			
			System.out.println("broken link is"+ links.getText());
			Assert.assertTrue(false);
		}
		}

	}

}
