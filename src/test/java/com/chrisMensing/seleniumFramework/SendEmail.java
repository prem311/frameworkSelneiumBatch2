package com.chrisMensing.seleniumFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chrisMensing.seleniumFramework.PageObjects.GmailPage;
import com.chrisMensing.seleniumFramework.PageObjects.HomePage;
import com.chrisMensing.seleniumFramework.PageObjects.SignInPage;

import resources.DataProviders;

public class SendEmail{
	@DataProvider(parallel = false, name = "GmailTest")
	public static Object[][] getLoginTestDetails()
	{
		return DataProviders.getTestDetails("EmailsToSend", 7);
	}

	@Test(dataProvider = "GmailTest")
	public void TestSendEmail(String Broswer, String Email, String Password, String To, String Subject, String Body, Boolean Delete)
	{
		
		HomePage HomePageObj = new HomePage(Broswer);
		HomePageObj.ClickOnSignIn();
		SignInPage SignInPageObj = new SignInPage(HomePageObj);
		SignInPageObj.SignIn(Email, Password);
		GmailPage GmailObj = new GmailPage(SignInPageObj);
		HomePageObj.ClickOnGmail();
		GmailObj.SendEmail(Body, Subject, To);
		GmailObj.ImplicitWait(10);
		GmailObj.CloseDriver();
	}
	
	//TODO: Finish My Received Email Test
//	@Test()
//	public void TestEmailReceived()
//	{
//		HomePage HomePageObj = new HomePage("Chrome");
//		HomePageObj.ClickOnSignIn();
//		SignInPage SignInPageObj = new SignInPage(HomePageObj);
//		SignInPageObj.SignIn(Email, Password);
//	}
}
