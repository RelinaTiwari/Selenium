package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//li/a[text()='Nested Frames']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name ='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name='frameset-middle']/frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		
	}

}
