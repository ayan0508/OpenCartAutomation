package testClassPackage;

import org.testng.annotations.*;

public class DataProviderClass {
	
	@DataProvider(name = "newUserData")
	public static Object[][] getnewUserData() {
		return new Object[][] {
			{"ayanbanerjee921@gmail.com", "@Ayan2000"}
			};
	}
	
}
