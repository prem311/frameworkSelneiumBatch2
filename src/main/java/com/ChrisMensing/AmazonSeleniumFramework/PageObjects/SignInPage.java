package com.ChrisMensing.AmazonSeleniumFramework.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.PageSuper.PageType;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators.SignInPageLocators;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.Utils;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.Utils.OptionPaneType;
import com.ChrisMensing.AmazonSeleniumFramework.base.MainMethods;

public class SignInPage extends PageSuper{
public WebDriver DriverToUse; 
SignInPageLocators SignInPageLocatorsObj;

	public SignInPage(HomePage TheHomePage)
	{
		Driver = TheHomePage.GetDriver();
		SignInPageLocatorsObj = new SignInPageLocators();
		PageFactory.initElements(Driver, SignInPageLocatorsObj);
		DriverToUse = Driver;
		CurrentPageType = PageType.SignedOn;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean SignIn(String Email, String Password)
	{
		Log.info("Attempting Login With Email : " + Email);
		MainMethods.SendKeyPress(SignInPageLocatorsObj.SignInEmail,Email + Keys.ENTER);
		
		
		//Checks for Wrong Email and returns false if email fails
		Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(!SignInPageLocatorsObj.SignInEmailIncorrect.isEmpty()) {
			return false;
		}
		
		
		//Enter Password
		@SuppressWarnings("rawtypes")
		Wait wait = new WebDriverWait(DriverToUse, 10); 
		WebElement ElementtoUse =  (WebElement) wait.until(ExpectedConditions.visibilityOf(SignInPageLocatorsObj.SignInPassword));
		MainMethods.SendKeyPress(ElementtoUse,Password + Keys.ENTER);
		
		//Checks for wrong Password
		Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(!SignInPageLocatorsObj.SignInEmailIncorrect.isEmpty()) {
			return false;
		}
		
		//Checks For One Time Password and ask user to input Password. I could also Automate this with the Gmail API if I had more time.
		if (Driver.getTitle().equals( "Authentication required")) 
		{
			MainMethods.ClickOnWebElement(SignInPageLocatorsObj.SendOTPButton);
			Log.warn("Asking the user for a One Time Password");
			String OTP = null;
			//I also added this so I know what Instance each is tied to. 
			Capabilities cap = ((RemoteWebDriver) Driver).getCapabilities();
			Utils UtilsObj = Utils.getInstance();
			OTP = UtilsObj.DisplayOptionPane
					(
					"Please Check The email used for the test on "+ cap.getBrowserName()+" and enter the One Time Password here then click Ok" , "Need OTP input", OptionPaneType.Text);
			Assert.assertTrue(OTP != null);
			MainMethods.SendKeyPress(SignInPageLocatorsObj.OTPField, OTP + Keys.ENTER);
		}
		
		
		return true;
	}
	
	//Checks if the User is signed in. I put this here because it made the most sense to me
	public boolean IsUserSignedIn()
	{
		HomePage HomePageObj = new HomePage(Driver);
		HomePageObj.GoToYourAccount();
		return !IsCurrentPageSignOn();
		
	}
	
	public boolean IsCurrentPageSignOn()
	{
		try 
		{
			MainMethods.SendKeyPress(SignInPageLocatorsObj.SignInEmail,"");
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

}
