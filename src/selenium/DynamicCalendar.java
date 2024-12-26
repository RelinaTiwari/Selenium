package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicCalendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		/*WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.id("form-field-travel_comp_date")));*/
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		WebElement date = driver.findElement(By.xpath("//section // input[@id='form-field-travel_comp_date']"));
		date.click();
		//js.executeScript("document.querySelector('#form-field-travel_comp_date')");
		/*Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//form[@class ='elementor-form'] //input[@id ='form-field-travel_from']"))).click().build().perform();
		//selecting dates
		String date = "10";
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class ='dayContainer'] /span[contains(@class,'flatpickr-day ')]"));
		for(int i=0;i<dates.size();i++)
		{
			String indexdate = dates.get(i).getText();
			if(indexdate.equalsIgnoreCase(date))
			{
				dates.get(i).click();
			}
		}*/

	}

}
