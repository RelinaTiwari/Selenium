package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebTable {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//div/input[@id = 'search-field']")).sendKeys("apple");
		List<WebElement> vegetable = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')] //tbody/tr/td[1]"));
		List<WebElement> filterveg =  vegetable.stream().filter(s->s.getText().contains("apple")).collect(Collectors.toList());
		Assert.assertEquals(vegetable.size(), filterveg.size());
		
	}

}
