package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions a = new Actions(driver);
		driver.findElement(By.xpath("//div[@class ='cen-left-align']/fieldset/input[@id ='autocomplete']")).sendKeys("uni");
		List<WebElement> values = driver.findElements(By.xpath("//ul[@id ='ui-id-1'] /li[@class='ui-menu-item']/div[@class='ui-menu-item-wrapper']"));
		for (int i=0;i<values.size();i++)
		{
			//String value = driver.findElement(By.xpath("")).getText();
			System.out.println(values.get(i).getText());
			if(values.get(i).getText().equalsIgnoreCase("Tunisia"))
			{
				a.moveToElement(values.get(i)).click().build().perform();
				break;
			}
		}
	}

}
