package com.chrisMensing.seleniumFramework.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.HomePageLocators;
import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.SignInPageLocators;
import com.chrisMensing.seleniumFramework.base.MainMethods;

public class HomePage extends PageSuper{
	HomePageLocators HomePageLocatorsObj;

	//A homepage constructor that opens a new WebDriver.
	public HomePage(String BrowserToOpen)
	{
		Driver = GetDriver(BrowserToOpen);
		HomePageLocatorsObj = new HomePageLocators();
		PageFactory.initElements(Driver, HomePageLocatorsObj);
	}
	
	//Overloaded Constructor to use when navigating back to the HomePage
	public HomePage(WebDriver DriverToUse)
	{
		Driver = DriverToUse;
		HomePageLocatorsObj = new HomePageLocators();
		PageFactory.initElements(Driver, HomePageLocatorsObj);	
	}
	
	public void SearchTerm(String StringToSearch) 
	{
		MethodToPreform.ClickOnWebElement(HomePageLocatorsObj.SearchBar);
		MethodToPreform.SendKeyPress(HomePageLocatorsObj.SearchBar,StringToSearch + Keys.ENTER);
	}
	
	public void ClickOnSignIn()
	{
		Wait wait = new WebDriverWait(Driver, 10); 
		WebElement ElementtoUse =  (WebElement) wait.until(ExpectedConditions.visibilityOf(HomePageLocatorsObj.SignInButton));
		MethodToPreform.ClickOnWebElement(HomePageLocatorsObj.SignInButton);	
	}
	
	public void GoToYourAccount ()
	{
		MethodToPreform.ClickOnWebElement(HomePageLocatorsObj.AccountDropDown);
	}
	
}
