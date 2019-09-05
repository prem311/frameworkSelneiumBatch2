package com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class YourAccountPageLocators {
	
	@FindBy(css= "div[data-card-identifier='SignInAndSecurity']")
	@CacheLookup
	public WebElement Secuity;

}
