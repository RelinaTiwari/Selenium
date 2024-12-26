package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//div[@class='picker-first2']//input[@id='ctl00_mainContent_view_date1']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class ='picker-second']")).getAttribute("style"));
		driver.findElement(By.xpath("//input[@id ='ctl00_mainContent_rbtnl_Trip_1']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class ='picker-second']")).getAttribute("style"));
		if(driver.findElement(By.xpath("//div[@class ='picker-second']")).getAttribute("style").contains("1"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}