package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PerformWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//div[@class = 'cart'] //a[@class = 'cart-header-navlink'])[1]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div//table[contains(@class , 'table-bordered')]//tr/th[1]")).click();
		//List<WebElement> vegetable = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')] //tbody/tr/td[1]"));
		
		List<WebElement> vegetablestable;
		List<String> value;
		//List<String> value = vegetablestable.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceValue(s)).collect(Collectors.toList());
		
		do 
		{
			vegetablestable = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
			value = vegetablestable.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceValue(s)).collect(Collectors.toList());
			if(value.size()<1)
			{
				driver.findElement(By.xpath("//div[@class='container']//li/a[@aria-label ='Next']")).click();
			}
			
		}while(value.size()<1);
		value.forEach(s->System.out.println(s));
		//vegetablestable.stream().filter(s->s.getText().contains("Rice")).map(s->s.getPriceValue()).collect(Collectors.toList());
		
		
		//Using streams
		
		/*List<String> original = vegetable.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> finalL = original.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(original, finalL);*/
		
		//general method 
		/*ArrayList<String> sorted = new ArrayList<String>();
		String value="";
		for(WebElement x: vegetable)
		{
			value = x.getText();
			sorted.add(value);
		}
		List<String> initialStream = sorted.stream().collect(Collectors.toList());
		List<String> finalStream = sorted.stream().sorted().collect(Collectors.toList());*/
		
		
	}

	private static String getPriceValue(WebElement s) {
		// TODO Auto-generated method stub
		String value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return value;
	}
	

}
