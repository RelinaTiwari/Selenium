package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HandleBrokenURL {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Scroll page 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		//for soft assertions
		SoftAssert sa = new SoftAssert();
		
		WebElement subdriver = driver.findElement(By.xpath("//div[@id ='gf-BIG']"));
		List<WebElement> links = subdriver.findElements(By.xpath("//div[@id ='gf-BIG']//td/ul//li[@class = 'gf-li']/a"));
		System.out.println(links.size());
		for (int i=0;i<links.size();i++)
		{
			//String url = subdriver.findElement(By.xpath("//table//ul/li/a[text() = 'Broken Link']")).getAttribute("href");
			String url = links.get(i).getAttribute("href");
			System.out.println(url);
			URL urln = new URL(url);
			System.out.println(urln.getHost());
			HttpURLConnection conn =  (HttpURLConnection)urln.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int code = conn.getResponseCode();
			//This is hard assert
			//Assert.assertTrue(code<400, "The link "+url+ "as response code is : "+code);
			//Soft assert
			sa.assertTrue(code<400, "The link "+url+ "as response code is : "+code);
		}
		
		sa.assertAll();
	}

}
