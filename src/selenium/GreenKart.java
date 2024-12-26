package selenium;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] items= {"Cauliflower","Beetroot","Brocolli"};
		//apply Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//define different method for adding items
		GreenKart add = new GreenKart();
		add.additems(driver,items);
		
		GreenKart proceed = new GreenKart();
		proceed.proceedToCancel(driver);
		
	}
	public void proceedToCancel(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='cart']/a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//div/button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//div[@class='products'] //input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div/button[@class='promoBtn']")).click();
		//Thread.sleep(7000);
		//apply Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(7));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[text()='Code applied ..!']")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//div/span[text()='Code applied ..!']")).getText(), "Code applied ..!");
		driver.findElement(By.xpath("//div/button[text()='Place Order']")).click();
		
	}
	public void additems(WebDriver driver,String[] items) throws InterruptedException
	{
		List itemlist = Arrays.asList(items);
		System.out.println(itemlist);
		int j=0;
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		for(int i=0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			String realname = name[0].trim();
			System.out.println(realname);
			if(itemlist.contains(realname))
			{
				Thread.sleep(2000);
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			if(j==3)
			{
				break;
			}
		}
	}

}
