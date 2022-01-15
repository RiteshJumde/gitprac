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

public class validateTitle extends base {
	
	public WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to homepage");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{	
		LandingPage l = new LandingPage(driver);	
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES12");
		Log.info("Successfully validated text");
		
	}
	
}
