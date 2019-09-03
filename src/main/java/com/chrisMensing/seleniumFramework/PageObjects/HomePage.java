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
public WebDriver DriverToUse; 

	public HomePage(String BrowserToOpen)
	{
		Driver = GetDriver(BrowserToOpen);
		PageFactory.initElements(Driver, HomePageLocators.class);
		DriverToUse = Driver;
	}
	
	public void SearchTerm(String StringToSearch) 
	{
		MethodToPreform.ClickOnWebElement(HomePageLocators.SearchBar);
		MethodToPreform.SendKeyPress(HomePageLocators.SearchBar,StringToSearch + Keys.ENTER);
	}
	
	public void CheckAscendumSearch()
	{
		SearchTerm("Ascendum");
		MethodToPreform.ClickOnWebElement(HomePageLocators.AscendumLink);
		Assert.assertEquals(DriverToUse.getTitle(), "Ascendum - A Global Digital Transformation Acceleration Firm in Cincinnati");
	}
	
	public void ClickOnGmail()
	{
		Wait wait = new WebDriverWait(DriverToUse, 20); 
		WebElement ElementtoUse =  (WebElement) wait.until(ExpectedConditions.visibilityOf(HomePageLocators.GmailButton));
		MethodToPreform.ClickOnWebElement(ElementtoUse);
	}
	
	public void ClickOnSignIn()
	{
		MethodToPreform.ClickOnWebElement(HomePageLocators.SignInButton);	
	}
	
	public void ClickOnGooogleApps()
	{
		MethodToPreform.ClickOnWebElement(HomePageLocators.GoogleAppsButton);
	}
	
	public void ClickOnTranslateApp()
	{
		ClickOnGooogleApps();
		Wait wait = new WebDriverWait(DriverToUse, 10); 
		WebElement ElementtoUse =  (WebElement) wait.until(ExpectedConditions.visibilityOf(HomePageLocators.TranslateApp));
		MethodToPreform.ClickOnWebElement(ElementtoUse);
	}

}
