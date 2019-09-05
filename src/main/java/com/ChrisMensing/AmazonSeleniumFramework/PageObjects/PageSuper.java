package com.ChrisMensing.AmazonSeleniumFramework.PageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.ChrisMensing.AmazonSeleniumFramework.Utils.ConstantVars;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.Utils;
import com.ChrisMensing.AmazonSeleniumFramework.base.MainMethods;
import com.ChrisMensing.AmazonSeleniumFramework.base.WedDriverBuilder;

public class PageSuper {
	MainMethods MethodToPreform;
	WebDriver Driver;
	Utils UtilsObj;
	Logger Log = Logger.getRootLogger();
	
	PageSuper(){
		MethodToPreform = new MainMethods();
		UtilsObj = Utils.getInstance();
		Log.info("Constucting Page Object :" + this);
	}
	
	public WebDriver GetDriver(String BroswerToOpen) 
	{
		if (Driver == null ) 
		{
		WedDriverBuilder NewDriver = new WedDriverBuilder(BroswerToOpen);
		Driver = NewDriver.GetBroswer();
		Driver.manage().window().maximize();
		Driver.get(ConstantVars.URL);
		}
		return Driver;
	}
	
	public void ImplicitWait(int Time)
	{
		Driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}
	
	public WebDriver GetDriver() 
	{
		return this.Driver;
	}
	
	public void CloseDriver()
	{
		Log.info("Closing Driver");
		Driver.close();
	}
	
	@AfterSuite
	public void CleanUp()
	{
		Log.info("Closing Down Suite");
		System.exit(0);
	}
}
