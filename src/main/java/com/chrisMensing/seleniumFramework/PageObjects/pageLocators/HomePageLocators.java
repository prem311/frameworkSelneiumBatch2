package com.chrisMensing.seleniumFramework.PageObjects.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators 
{
	
	@FindBy(id= "gb_70")
	@CacheLookup
	public static WebElement SignInButton;
	
	@FindBy(xpath= "//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")
	@CacheLookup
	public static WebElement SearchBar;
	
	@FindBy(name= "btnK")
	@CacheLookup
	public static WebElement GoogleSearchButton;
	
	@FindBy(linkText= "Gmail")
	@CacheLookup
	public static WebElement GmailButton;
	
	@FindBy(className= "gb_z")
	@CacheLookup
	public static WebElement Apps;
	
	@FindBy(partialLinkText= "Ascendum - A Global Digital")
	@CacheLookup
	public static WebElement AscendumLink;
	
	@FindBy(xpath= "//*[@title='Google apps']")
	@CacheLookup
	public static WebElement GoogleAppsButton;
	
	@FindBy(linkText= "Translate")
	@CacheLookup
	public static WebElement TranslateApp;
}
