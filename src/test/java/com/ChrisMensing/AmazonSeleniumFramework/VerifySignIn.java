package com.ChrisMensing.AmazonSeleniumFramework;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.HomePage;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.SignInPage;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.DataProviders;

public class VerifySignIn{

	//I just call The method in the Data Providers class
	@DataProvider(parallel = true, name = "LoginTest")
		public static Object[][] getLoginTestDetails(){
			DataProviders TestLoginDetails = new DataProviders("TestData.xlsx");
			TestLoginDetails.LoadSourceTabData("Amazon Test Logins");
			return TestLoginDetails.getTestDetails();
	}

	@Test(dataProvider = "LoginTest")
	public void SignInTest(String TestName, String BroswerToLaunch, String Email, String Password, Boolean ValidLogin) 
	{	
		Logger Log = Logger.getRootLogger();
		Log.info("Starting Test: " + TestName);
		HomePage HomePageObj = new HomePage(BroswerToLaunch);
		HomePageObj.ClickOnSignIn();
		SignInPage SignInObj = new SignInPage(HomePageObj);
		boolean SignInSuccess = false;
		SignInSuccess = SignInObj.SignIn(Email, Password);
		
		//This will allow me to pass the sign in if it is a Negative test
		if(ValidLogin) 
		{
			Assert.assertTrue( SignInSuccess && SignInObj.IsUserSignedIn());
		}
		else 
		{ 
			Assert.assertFalse(SignInSuccess || ValidLogin);
		}
		
		Log.info("Finished Test: " + TestName);
		SignInObj.CloseDriver();
	}
}
