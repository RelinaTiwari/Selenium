package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//fetch name of checkbox
		String nameofcheckbox="";
		driver.findElement(By.xpath("//div[@id ='checkbox-example']//label/input[@id ='checkBoxOption3']")).click();
		WebElement checkclick = driver.findElement(By.xpath("//div[@id ='checkbox-example']"));
		List<WebElement> checkBox = checkclick.findElements(By.xpath("//label/input[@type='checkbox']"));
		List<WebElement> cblabel = checkclick.findElements(By.tagName("label"));
		System.out.println(checkBox.size());
		
		for(int i =0;i<checkBox.size();i++)
		{
			if(checkBox.get(i).isSelected())
			{
				nameofcheckbox = cblabel.get(i).getText();
				 
			}
		}
		System.out.println(nameofcheckbox);

		
		//selecting dropdown of same label
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		List<WebElement> options = dropdown.getOptions();
		for(int i =0;i<options.size();i++)
		{
			//System.out.println(options.get(i).getText());
			if(options.get(i).getText().contains(nameofcheckbox))
			{
				options.get(i).click();
			}
		}
		
		//Enter name of same label
		driver.findElement(By.xpath("//fieldset/input[@id = 'name']")).sendKeys(nameofcheckbox);
		driver.findElement(By.xpath("//fieldset/input[@id ='alertbtn']")).click();
		String content = driver.switchTo().alert().getText();
		if(content.contains(nameofcheckbox))
		{
			System.out.println(nameofcheckbox+" is present ");
		}
		driver.switchTo().alert().accept();
	}

}
