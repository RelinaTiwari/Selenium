package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		//Actions a = new Actions(driver);
		//a.moveToElement("//li/a[text()='Multiple Windows']").click().build().perform();
		driver.findElement(By.xpath("//li/a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//div[@class ='example']/a[@target ='_blank']")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.xpath("//div/h3[text()='New Window']")).getText());
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//div[@class ='example']/h3")).getText());
		
	}

}
