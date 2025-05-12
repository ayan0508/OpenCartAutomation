package testClassPackage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.*;

import PageObjectClass.AddToCart;
import PageObjectClass.CheckOutItems;
import PageObjectClass.Login;
import junit.framework.Assert;

public class TestClass {
	String URL="https://demo.opencart.com/";
	public static WebElement element=null;
	public static WebDriver driver;
	public double TotalPrice;
	@BeforeTest
	public WebDriver setUpTest() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in full-screen
        options.addArguments("--disable-blink-features=AutomationControlled"); // Bypass bot detection
        options.addArguments("--no-sandbox"); // Prevent sandboxing
        // Add a random User-Agent
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
		driver.get(URL);
		Thread.sleep(30000);
		return driver;
	}
	
	@Test (dataProvider="newUserData",dataProviderClass=DataProviderClass.class)
	public void Login(String email,String pass)
	{
		Login lg=new Login(driver);
		lg.moveToLoginPgae(email, pass);
		//System.out.print(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Your Store");
		
	}
	
	@Test
	public void clearCart() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
		driver.findElement(By.xpath("//div[@class=\"input-group\"]/button[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='logo']/a")).click();
	}

	@Test(dependsOnMethods= {"clearCart"})
	public void addToCart()
	{
		//if(driver==null) System.out.print("Hi driver is null");
		AddToCart ac=new AddToCart(driver);
		int Total_Items=ac.totalElements();
		System.out.print(Total_Items);
		Assert.assertEquals(Total_Items,4);
		TotalPrice=ac.addToCartItems();
		ac.clickToCart();
		System.out.print("TotalPrice for addToCart:");
		System.out.println(TotalPrice);
	}
	
	 @Test(dependsOnMethods= {"addToCart"})
	 public void CheckTotalValue()
	 {
		 String getPrice=driver.findElement(By.xpath("//tfoot[@id='checkout-total']/tr[4]/td[2]")).getText().replaceAll("[^0-9.]", "");
		  double actualPrice=Double.parseDouble(getPrice);
		  System.out.print("actualPrice for CheckTotalValue:");
		  System.out.print(actualPrice);
		 Assert.assertEquals(actualPrice, TotalPrice);
	 }
	
	@Test(dependsOnMethods= {"CheckTotalValue"})
	public void checkoutItems()
	{
		CheckOutItems chkout=new CheckOutItems(driver);
		String actual_res=chkout.checkOut();
		Assert.assertEquals(actual_res, " ");
	}
	@Test(dependsOnMethods= {"checkoutItems"})
	public void confirmOrder()
	{
		//div[@class='text-end']/button
		boolean isEnable=driver.findElement(By.xpath("//div[@class='text-end']/button")).isEnabled();
		Assert.assertEquals(isEnable, true);
	}
}
