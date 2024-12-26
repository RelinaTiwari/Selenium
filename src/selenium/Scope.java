package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//print size of all inks present in web page
		System.out.println(driver.findElements(By.tagName("a")).size());
		//print size of all links present in footer of page
		WebElement footer = driver.findElement(By.xpath("//div[@id ='gf-BIG']"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		//Print size of links present in 1st coloum of footer tab
		WebElement FirstCol = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int colsize = FirstCol.findElements(By.tagName("a")).size();
		System.out.println(colsize);
		//click on each link so that it opens in saperate tabs
		for(int i=1;i<colsize;i++)
		{
			String presskey = Keys.chord(Keys.CONTROL,Keys.ENTER);
			FirstCol.findElements(By.tagName("a")).get(i).sendKeys(presskey);
			Thread.sleep(5000);
		}
		//Print title of each webpagep
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		for(int i =0;i<windows.size();i++)
		{
			String newWindow = it.next();
			driver.switchTo().window(newWindow);
			System.out.println(driver.getTitle());
		}
		
		
	}

}
