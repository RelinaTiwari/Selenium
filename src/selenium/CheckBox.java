package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		}
}
