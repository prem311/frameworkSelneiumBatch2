package com.ChrisMensing.AmazonSeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.HomePage;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.SignInPage;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.DataProviders;

public class SignIn{

	//I just call The method in the Data Providers class
	@DataProvider(parallel = true, name = "LoginTest")
		public static Object[][] getLoginTestDetails(){
			return DataProviders.getTestDetails("TestData.xlsx", "Amazon Test Logins", 4);
	}

	@Test(dataProvider = "LoginTest")
	public void SignInTest(String BroswerToLaunch, String Email, String Password, Boolean ValidLogin) 
	{		
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
		
		SignInObj.CloseDriver();
	}
}
