package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginChildPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//body/a[@class ='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		System.out.println(driver.findElement(By.xpath("//div/p[@class='im-para red']")).getText());
		String message = driver.findElement(By.xpath("//div/p[@class='im-para red']")).getText();
		String[] extract = message.split("at");
		String[] getpassword = extract[1].split("with");
		String password = getpassword[0].trim();
		System.out.println(password);
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//div[@class='form-group']/input[@id ='username']")).sendKeys(password);
		
		
		
	}

}
