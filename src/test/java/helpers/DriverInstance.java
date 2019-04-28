package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverInstance {
	public static WebDriver driver;
	WebDriverWait wait;
	public static void startDriver(){
		try{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	public static void closeBrowser(){
		driver.close();
	}

}