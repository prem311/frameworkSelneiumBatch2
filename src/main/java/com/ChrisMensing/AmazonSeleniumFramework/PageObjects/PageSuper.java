package com.ChrisMensing.AmazonSeleniumFramework.PageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.ChrisMensing.AmazonSeleniumFramework.Utils.ConstantVars;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.Utils;
import com.ChrisMensing.AmazonSeleniumFramework.base.WedDriverBuilder;

public class PageSuper {
	public enum PageType {Search, product, HomePage, SignedOn, account}
	public PageType CurrentPageType;
	WebDriver Driver;

	Logger Log = Logger.getRootLogger();
	
	PageSuper(){
		Utils.getInstance();
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
		NewDriver = null;
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
	
	public void StorePage()
	{
		ConstantVars.StorePage(CurrentPageType, this);
	}
	
	@AfterSuite
	public void CleanUp()
	{
		Log.info("Closing Down Suite");
		System.exit(0);
	}
}
