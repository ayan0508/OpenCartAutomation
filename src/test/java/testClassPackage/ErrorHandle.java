package testClassPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ErrorHandle {

	
	public static String TakeScreenShot(String testcasename,WebDriver driver) throws IOException
	{
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		
		//Copy file at destination
		FileHandler.copy(SrcFile, DestFile);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
	}
}
