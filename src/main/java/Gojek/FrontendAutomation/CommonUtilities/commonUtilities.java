package Gojek.FrontendAutomation.CommonUtilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class commonUtilities {
	
	public static Properties getLocators(String propertyFile) {
		FileInputStream file = null;
		Properties prop = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//locators//"+propertyFile+".properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Unable to load property file"+e.getMessage());
		}
		return prop;
	}
	
	public static Properties getTestData(String propertyFile) {
		FileInputStream file = null;
		Properties prop = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"//"+propertyFile+".properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Unable to load property file"+e.getMessage());
		}
		return prop;
	}
	
	public static WebElement findElement(WebDriver driver, String elem) {
		return driver.findElement(By.xpath(elem));
	}
	
	public static void clickElement(WebDriver driver, String elem) {
		findElement(driver, elem).click();
	}
	
	public static void fillDataInTextBox(WebDriver driver, String elem, String data) {
		findElement(driver, elem).clear();
		findElement(driver, elem).sendKeys(data);
	}
	
	public static boolean verifyElementIsDisplayed(WebDriver driver, String elem) {
		return findElement(driver, elem).isDisplayed();
	}
	
	public static String getText(WebDriver driver, String elem) {
		return findElement(driver, elem).getText().toString().trim();
	}
	
	public static boolean compareStrings(String actual, String expected) {
		return actual.equalsIgnoreCase(expected);
	}
	
	public static void waitForElementVisibility(WebDriver driver, String elem) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
		
	}
	
	public static void waitForElementInvisibility(WebDriver driver, String elem) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elem)));
		
	}
	
	public static void switchFrame(WebDriver driver, String elem) {
		driver.switchTo().frame(findElement(driver, elem));
	}
	
	public static void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

}
