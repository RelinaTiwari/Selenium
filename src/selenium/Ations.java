package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Ations move = new Ations();
		move.moveMouse(driver);
		
		Ations send = new Ations();
		send.sendTextToElement(driver);
	}
	
	public void moveMouse(WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@id ='nav-tools']/a[@id='nav-link-accountList']"))).build().perform();
		
	}
	
	public void sendTextToElement(WebDriver driver)
	{
		WebElement address = driver.findElement(By.xpath("//div/input[@id ='twotabsearchtextbox']"));
		Actions a = new Actions(driver);
		a.moveToElement(address).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
