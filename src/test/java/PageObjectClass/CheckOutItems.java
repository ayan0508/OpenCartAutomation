package PageObjectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CheckOutItems {
	
	WebDriver driver;
	WebDriverWait wait;
	public CheckOutItems(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public String checkOut()
	{
		driver.findElement(By.xpath("//div[@class='col text-end']/a")).click();
		wait.until(ExpectedConditions.urlToBe("https://demo.opencart.com/en-gb?route=checkout/checkout"));
		Actions ac=new Actions(driver);
		WebElement element=driver.findElement(By.id("button-payment-methods"));
		ac.moveToElement(element).perform();
		
		String actual_result=driver.findElement(By.id("error-payment-method")).getText();
		return actual_result;
	}
}
