package PageObjectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.AbstractMethode;

public class AddToCart  {
	
	WebDriver driver;
	public double totalPrice=0;
	List<WebElement> totalItems;
	WebDriverWait wt;
	public AddToCart(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		wt=new WebDriverWait(driver,Duration.ofSeconds(15));
	}

	public int totalElements()
	{
		try {
		totalItems=wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4']/div")));}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return totalItems.size();
	}
	public double addToCartItems()
	{
		WebElement macBook = driver.findElement(By.id("content"));
		Actions ac=new Actions(driver);	
		
		try {
		WebElement product=wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col mb-3'][1]/div/div/a/img")));
		ac.moveToElement(product).perform();
		product.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		String price=wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='price-new']"))).getText();
		String quantity="2";
		driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
		driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys(quantity);
		
		price=price.replaceAll("[^0-9.]", "");
		
		double priceValue = Double.parseDouble(price);
		
		totalPrice=priceValue*Integer.parseInt(quantity); 
		System.out.print("totalPrice for inner:");
		System.out.println(totalPrice);
		try {
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return totalPrice;
	}
	public void clickToCart()
	{
		driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
	}
}
