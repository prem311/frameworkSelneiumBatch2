package com.chrisMensing.seleniumFramework.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.GmailLocators;

public class GmailPage extends PageSuper{

	public GmailPage(PageSuper Page)
	{
		Driver = Page.GetDriver();
		PageFactory.initElements(Driver, GmailLocators.class);
	}
	
	public void SendEmail(String EmailTextToSend, String Subject, String EmailTo)
	{
		
		
		
		Wait wait = new WebDriverWait(Driver, 20); 
		WebElement ElementtoUse =  (WebElement) wait.until(ExpectedConditions.visibilityOf(GmailLocators.ComposeEmail));
		MethodToPreform.ClickOnWebElement(ElementtoUse);
		Wait wait2 = new WebDriverWait(Driver, 20); 
		WebElement ElementtoUse2 =  (WebElement) wait2.until(ExpectedConditions.visibilityOf(GmailLocators.EmailTo));
		MethodToPreform.SendKeyPress(ElementtoUse2, EmailTo);
		MethodToPreform.SendKeyPress(GmailLocators.EmailSubject, Subject);
		MethodToPreform.ClickOnWebElement(GmailLocators.EmailBody);
		MethodToPreform.SendKeyPress(GmailLocators.EmailBody, EmailTextToSend);
		MethodToPreform.ClickOnWebElement(GmailLocators.SendButton);
	}

}
