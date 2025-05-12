package PageObjectClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.AbstractMethode;

public class Login  {
	
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	public void moveToLoginPgae(String email,String pass)
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@data-popper-placement='bottom-start']/li[2]")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement element= driver.findElement(By.xpath("//div[@id='content']/h2"));
		
		driver.findElement(By.xpath("//div[@id='logo']/a")).click();
		
	}
	
}
