package com.chrisMensing.seleniumFramework.PageObjects.pageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocators {
	
	@FindBy(id= "ap_email")
	public WebElement SignInEmail;
	
	@FindBy(id= "ap_password")
	public WebElement SignInPassword;
	
	@FindAll(@FindBy(id= "auth-error-message-box"))
	public List<WebElement> SignInEmailIncorrect;
	
	@FindBy(id="continue")
	public WebElement SendOTPButton;
	
	@FindBy(name="code")
	public WebElement OTPField;
	

}
