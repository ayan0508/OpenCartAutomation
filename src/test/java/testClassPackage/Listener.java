package testClassPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.resources.ExtentReporterNg;

public class Listener implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReporterNg.config();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed"); // ✅ Log pass status
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		// TODO Auto-generated method stub
		try {
			 driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String filepath=null;
		try {
			filepath=ErrorHandle.TakeScreenShot(result.getMethod().getMethodName(),driver);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		 test.log(Status.FAIL, "Test Failed: " + result.getThrowable()); // ✅ Log failure
	        test.addScreenCaptureFromPath(filepath);
	}
	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
