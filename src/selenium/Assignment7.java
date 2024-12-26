package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		WebElement subdriver = driver.findElement(By.xpath("//fieldset/table[@id='product']"));
		System.out.println("Number of rows "+subdriver.findElements(By.tagName("tr")).size());
		System.out.println("Number of columns "+subdriver.findElements(By.xpath("//tbody/tr/th")).size());
		System.out.println(driver.findElements(By.xpath("//fieldset/table/tbody/tr[3]/td")).size());
		List<WebElement>  value = driver.findElements(By.xpath("//fieldset/table/tbody/tr[3]/td"));
		for (int i =0;i<value.size();i++)
		{
			System.out.println(value.get(i).getText());
		}
	}

}
