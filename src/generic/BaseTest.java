package generic;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompages.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

public class BaseTest implements IAutoConstant {

	 public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		//Setup path of the driver executables
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		//Launch the browser 
		driver=new ChromeDriver();
		//Enter the URL
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOU, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		String url=Lib.getPropertyValue("URL");
		driver.get(url);
		
	}








	@AfterMethod
	public void tearDown(ITestResult T) {

		if(ITestResult.FAILURE==T.getStatus())
			Lib.captureScreenshot(driver, T.getName());

		//Close the Browser
		//driver.close();

	}


}
