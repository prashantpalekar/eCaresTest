package com.test.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.test.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfg=new ReadConfig();
	public String browserNm =readconfg.getBrowserNm();
	public String baseURL =readconfg.getBaseURL();
	public String username =readconfg.getUsername();
	public String password =readconfg.getPassword();
	
	public String random5CharString=RandomStringUtils.randomAlphabetic(5);
	public String random5DigitAlphaNumeric=RandomStringUtils.randomAlphanumeric(5);
	
	public static WebDriver driver;
	public String TC1Assertion = "Home Page";
	public static Logger logger;

	@BeforeClass
	public void selectBrowser() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (browserNm.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserNm.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserNm.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserNm.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Entered browser name does not match");
		}
		logger=Logger.getLogger("FirstMavenTestProject");
		PropertyConfigurator.configure("Log4j.properties");
		
	}

	@AfterClass
	public void tearDown() {
		// driver = new ChromeDriver();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tcName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceD=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/V2Screenshots/"+ tcName +".png");
		FileUtils.copyFile(sourceD, target);
		System.out.println(tcName+" Screenshot taken");
	}
	

}
