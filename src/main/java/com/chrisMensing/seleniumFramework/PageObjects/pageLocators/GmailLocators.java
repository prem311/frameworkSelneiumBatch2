package com.chrisMensing.seleniumFramework.PageObjects.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GmailLocators {
		
	@FindBy(css= ".T-I-KE")
	@CacheLookup
	public static WebElement ComposeEmail;

	@FindBy(name= "to")
	@CacheLookup
	public static WebElement EmailTo;
		
	@FindBy(name= "subjectbox")
	@CacheLookup
	public static WebElement EmailSubject;
	
	@FindBy(xpath= "//*[@aria-label=\"Message Body\" and @role = \"textbox\"]")
	@CacheLookup
	public static WebElement EmailBody;
	
	
	@FindBy(css= ".dC")
	@CacheLookup
	public static WebElement SendButton;
	
	//TODO: Make a list to find all the emails like this
	@FindBy(linkText= "Test")
	@CacheLookup
	public static WebElement RecivedEmailSubject;
	
	//Needs to Have the email open
	@FindBy(linkText= "This Is a Test Email")
	@CacheLookup
	public static WebElement RecivedEmailBody;
	
	//Needs to Have the email open
	@FindBy(css= ".aaq")
	@CacheLookup
	public static WebElement ReplyEmail;
	
	@FindBy(id= ":f0")
	@CacheLookup
	public static WebElement EmailReplyBody;
	
	@FindBy(id= ":b0")
	@CacheLookup
	public static WebElement EmailReplySend;

	//Needs to Have the email open
	@FindBy(css= ".iH > div:nth-child(1) > div:nth-child(2) > div:nth-child(3)")
	@CacheLookup
	public static WebElement DelEmail;
	
	//Needs to Have the email open
	@FindBy(css= ".lS")
	@CacheLookup
	public static WebElement BackToEmails;
	
}
	
