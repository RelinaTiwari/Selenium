package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Scroll webpage
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		//Scroll emement in webpage
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Find sum of values in one column
		List<WebElement> values = driver.findElements(By.xpath("//div[@class ='tableFixHead'] //tr/td[4]"));
		int sum = 0;
		for(int i=0;i<values.size();i++)
		{
			int value = Integer.parseInt(values.get(i).getText());
			sum =sum + value;
		}
		System.out.println(sum);
		
		String FetchedValue = driver.findElement(By.xpath("//div[@class ='totalAmount']")).getText();
		String[] SplitValue = FetchedValue.split(":");
		String GotValue = SplitValue[1].trim();
		int sumvalue = Integer.parseInt(GotValue);
		if(sum == sumvalue)
		{
			System.out.println("Correct");
		}
		
	}

}
