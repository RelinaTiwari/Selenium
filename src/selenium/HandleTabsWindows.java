package selenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTabsWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentwindow = it.next();
		String Childwindow = it.next();
		driver.switchTo().window(Childwindow);
		driver.get("https://rahulshettyacademy.com/");
		String name = driver.findElement(By.xpath("(//div[@class = 'lower-content']//div/h2/a)[1]")).getText();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//div[@class='form-group']/input[@name = 'name']")).sendKeys(name);
		
		//Taking ss of webelement
		WebElement coursename = driver.findElement(By.xpath("//div[@class='form-group']/input[@name = 'name']"));
		File file = coursename.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

		
		//getting height and weidth of webelement
		
	}

}
