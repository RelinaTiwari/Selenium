package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//form[contains(@class,'ng-pristine')] //input[contains(@class,'ng-invalid')]")).sendKeys("Relina");
		//driver.findElement(By.xpath("//form[contains(@class,'ng-pristine')] //input[contains(@class,'ng-invalid')]")).sendKeys("Email");
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("email");
		driver.findElement(By.xpath("//form/div/input[@id = 'exampleInputPassword1']")).sendKeys("Hello");
		driver.findElement(By.xpath("//form/div/input[@id = 'exampleCheck1']")).click();
		
		WebElement gender = driver.findElement(By.xpath("//select[@id = 'exampleFormControlSelect1']"));
		Select dropdown = new Select(gender);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		driver.findElement(By.xpath("//form/div[7]/input[@class='form-control']")).click();	
	}
}