package com.chrisMensing.seleniumFramework.PageObjects.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocators {
	
	@FindBy(name= "identifier")
	@CacheLookup
	public static WebElement SignInEmail;
	
	@FindBy(name= "password")
	@CacheLookup
	public static WebElement SignInPassword;


}
