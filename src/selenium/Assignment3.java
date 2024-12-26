package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		Assignment3 fillform = new Assignment3();
		fillform.formSubmission(driver);
		Assignment3 shop = new Assignment3();
		shop.buyProducts(driver);
		

	}

	public void formSubmission(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class = 'form-group']/input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class = 'form-group']/input[@id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("(//label[@class='customradio']/span[@class ='checkmark'])[2]")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/select[@class='form-control']")));
		Select dropdown = new Select(
				driver.findElement(By.xpath("//div[@class='form-group']/select[@class='form-control']")));
		dropdown.selectByValue("consult");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='form-group']/label/span/input[@id='terms']")).click();
		driver.findElement(By.xpath("//div[@class ='form-group']/input[@id ='signInBtn']")).click();
	}
	
	public void buyProducts(WebDriver driver)
	{
		WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(7));
		w.until(ExpectedConditions.urlContains("https://rahulshettyacademy.com/angularpractice/shop"));
		List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'card h-100']/div/h4"));
		
		System.out.println(items);
		for(int i=0;i<items.size();i++)
		{
			
			driver.findElements(By.xpath("//div[@class = 'card h-100']/div/button[@class='btn btn-info']")).get(i).click();
		}
		driver.findElement(By.xpath("//div/ul/li/a[contains(@class,'btn-primary')]")).click();
	}

}
