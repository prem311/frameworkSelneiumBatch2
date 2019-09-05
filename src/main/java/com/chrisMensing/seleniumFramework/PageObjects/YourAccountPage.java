package com.chrisMensing.seleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.YourAccountPageLocators;

public class YourAccountPage extends PageSuper{
	YourAccountPageLocators YourAccountPageLocatorsObj;
	
	YourAccountPage (WebDriver DriverToUse)
	{
		Driver = DriverToUse;
		YourAccountPageLocatorsObj = new YourAccountPageLocators();
		PageFactory.initElements(Driver, YourAccountPageLocatorsObj);
	}
	
	public void ClickOnSecurity()
	{
		
	}
	
	
}
