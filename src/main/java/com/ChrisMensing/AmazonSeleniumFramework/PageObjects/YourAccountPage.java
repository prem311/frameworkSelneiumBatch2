package com.ChrisMensing.AmazonSeleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators.YourAccountPageLocators;

public class YourAccountPage extends PageSuper{
	YourAccountPageLocators YourAccountPageLocatorsObj;
	
	YourAccountPage (WebDriver DriverToUse)
	{
		Driver = DriverToUse;
		YourAccountPageLocatorsObj = new YourAccountPageLocators();
		PageFactory.initElements(Driver, YourAccountPageLocatorsObj);
		CurrentPageType = PageType.account;
	}
	
	public void ClickOnSecurity()
	{
		
	}
	
	
}
