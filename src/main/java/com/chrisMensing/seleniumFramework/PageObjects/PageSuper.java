package com.chrisMensing.seleniumFramework.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.chrisMensing.seleniumFramework.base.MainMethods;
import com.chrisMensing.seleniumFramework.base.WedDriverBuilder;

import resources.ConstantVars;
import resources.Utils;

public class PageSuper {
	MainMethods MethodToPreform;
	WebDriver Driver;
	Utils UtilsObj;
	
	PageSuper(){
		MethodToPreform = new MainMethods();
		UtilsObj = new Utils();
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
		Driver.close();
	}
	
}
