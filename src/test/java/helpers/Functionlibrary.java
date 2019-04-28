package helpers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.DriverInstance;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Functionlibrary {
	WebDriver driver= DriverInstance.driver;
	WebDriverWait wait = new WebDriverWait(driver,5);
	String baseUrl="https://api.openweathermap.org/data/2.5/weather";
	PgJasonParser pageobject = new PgJasonParser();
	
	public void launchApplication() {
		driver.get(pageobject.getPageObjects("site"));
	}

	public void googleSearch(String searchTerm) {		
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(pageobject.getPageObjects("searchBox")))));
		element.sendKeys(searchTerm);
		element.sendKeys(Keys.ENTER);
	}

	public String verifySearchResult() {		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(pageobject.getPageObjects("results")))));
		String str=driver.findElement(By.className(pageobject.getPageObjects("resultPage"))).getText();
		return str;
	}

	public void browseTo() {
		driver.get(pageobject.getPageObjects("website"));	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(pageobject.getPageObjects("wizard")))));
	}

	public void toAndFro(String origin, String destination) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("flightTab"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(pageobject.getPageObjects("origin"))))).sendKeys(origin);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("destination"))))).sendKeys(destination);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("aria"))))).click();
		
	}

	public void travelerDetails(String noOfAdult, String noOfChild, String ageOfChild) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("travelers"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("noOfChildren"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(pageobject.getPageObjects("AgeOfChild1")))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("select")+ ageOfChild +"]")))).click();		
	}

	public void itineraryDetails() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("depart"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("departDate"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("returning"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("returningDate"))))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pageobject.getPageObjects("searchFlight"))))).click();
	}

	public void getRequest() {
		driver.close();
		System.out.println(baseUrl + "?id=5128581&APPID="+System.getenv("APPID")+"&cnt=2&units=metric");
		
		given().
		when().
		get(baseUrl + "?id=5128581&APPID="+System.getenv("APPID")+"&cnt=2&units=metric").
		
		then().assertThat().statusCode(200).and().body("main.temp_max",lessThanOrEqualTo(new BigDecimal(10).floatValue()));
		
	}

	public void captureScreenshot() {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		  // now copy the  screenshot to desired location using copyFile method
		 FileUtils.copyFile(src, new File(System.getenv("HOME")+"//screenshots//"+System.currentTimeMillis()+".png"));
		       }		 
		catch (IOException e)		 
		{		 
		System.out.println(e.getMessage());		 
		 }		
	}

	public WebElement verifyResult() {
		WebElement element= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(pageobject.getPageObjects("searchResult")))));
		return element;
		
	}
	
}
