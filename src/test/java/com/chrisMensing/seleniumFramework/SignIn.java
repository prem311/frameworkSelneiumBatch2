package com.chrisMensing.seleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chrisMensing.seleniumFramework.PageObjects.HomePage;
import com.chrisMensing.seleniumFramework.PageObjects.SignInPage;
import resources.DataProviders;

public class SignIn{

	//I just call The method in the Data Providers class
	@DataProvider(parallel = false, name = "LoginTest")
		public static Object[][] getLoginTestDetails(){
			return DataProviders.getTestDetails("Google Test Logins", 4);
	}

	@Test(dataProvider = "LoginTest")
	public void GoogleSignIn(String BroswerToLaunch, String Email, String Password, Boolean ValidLogin) 
	{		
		HomePage HomePageObj = new HomePage(BroswerToLaunch);
		HomePageObj.ClickOnSignIn();
		SignInPage SignInObj = new SignInPage(HomePageObj);
		boolean SignInSuccess = false;
		SignInSuccess = SignInObj.SignIn(Email, Password);
		
		//This will allow me to pass the sign in if it is a Negitive test
		if(ValidLogin) 
		{
			Assert.assertTrue( SignInSuccess && ValidLogin);
		}
		else 
		{ 
			Assert.assertFalse(SignInSuccess || ValidLogin);
		}
		SignInObj.CloseDriver();
	}
	

}
