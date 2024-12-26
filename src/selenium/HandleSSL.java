package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
public class HandleSSL {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Set behavior of ChromeDriver
		//for passing ssl certifications
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		//driver.get("https://expired.badssl.com/");
		//To maximize window
		driver.manage().window().maximize();
		Thread.sleep(4000);
		/*System.out.println(driver.getTitle());
		//for deleting cookies
		driver.manage().deleteAllCookies();
		driver.close();*/
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//take screen shorts
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Strote it from src to local
		FileUtils.copyFile(src,new File("C:\\Users\\relinat\\Desktop\\Personal\\ss.png"));		
	}

}
