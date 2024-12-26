package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		//find element above given web element 
		
		WebElement value = driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(value)).getText());
		
		//find element below web element
		
		WebElement dob = driver.findElement(By.xpath("//div[@class='form-group']/label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).sendKeys("07-11-1999");
		
		//find element to the left of web element
		
		WebElement left = driver.findElement(By.xpath("//div[@class ='form-check']/label[@for ='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(left)).click();
		
		//find element to the right of
		WebElement righty = driver.findElement(By.xpath("//input[@class = 'form-check-input']"));
		List<WebElement> Elementlist = driver.findElements(with(By.tagName("label")).toRightOf(righty));
		Elementlist.stream().forEach(s->System.out.println(s.getText()));
	}

}
