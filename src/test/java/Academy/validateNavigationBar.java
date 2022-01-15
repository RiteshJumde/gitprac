package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.base;

public class validateNavigationBar extends base {
	
	public WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{	
		LandingPage l = new LandingPage(driver);	
		Assert.assertTrue(l.getNavigationBar().isDisplayed());  
		Log.info("Navigation bar is displayed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
