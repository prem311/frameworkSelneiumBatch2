package com.amazon.base;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import resources.TestUtil;
import resources.ConstantVariables;



public class baseTest {
	
	public baseTest() {
		
		Initialize_Browser(); 
		
	}
	
	public static WebDriver chromedriver;
	
	@BeforeClass
	public static void Initialize_Browser() {
		
		System.out.println("grabbing file path for chrome drivers...");
		String chromedriverfilepath = System.getProperty("user.dir") + ConstantVariables.driverPath;
		
		System.setProperty("webdriver.chrome.driver", chromedriverfilepath);
		chromedriver = new ChromeDriver();
		
		String url = ConstantVariables.baseUrl;
		chromedriver.get(url);
		chromedriver.manage().window().maximize();
		chromedriver.manage().deleteAllCookies();
		chromedriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		chromedriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
	}
	
	
	public static void closeBrowser() {
		chromedriver.quit();
	}

	
	
}
