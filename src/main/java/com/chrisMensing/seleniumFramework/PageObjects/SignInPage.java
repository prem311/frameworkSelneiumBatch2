package com.chrisMensing.seleniumFramework.PageObjects;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.SignInPageLocators;

public class SignInPage extends PageSuper{
public WebDriver DriverToUse; 

	public SignInPage(HomePage TheHomePage)
	{
		Driver = TheHomePage.GetDriver();
		PageFactory.initElements(Driver, SignInPageLocators.class);
		DriverToUse = Driver;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean SignIn(String Email, String Password)
	{
		MethodToPreform.SendKeyPress(SignInPageLocators.SignInEmail,Email + Keys.ENTER);
		
		
		//TODO: Check for Wrong Email and return false if email fails 
		
		
		@SuppressWarnings("rawtypes")
		Wait wait = new WebDriverWait(DriverToUse, 10); 
		WebElement ElementtoUse =  (WebElement) wait.until(ExpectedConditions.visibilityOf(SignInPageLocators.SignInPassword));
		MethodToPreform.SendKeyPress(ElementtoUse,Password + Keys.ENTER);
		
		//TODO: Check for wrong Password
		
		
		return true;
		
	}

}
