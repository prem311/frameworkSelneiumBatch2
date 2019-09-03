package webPageActions;

import com.amazon.base.baseMethods;
import com.amazon.base.baseTest;

import webPageLocators.homePageLocators;
import com.amazon.base.*;

public class homePageActions extends baseTest{
	
	
	public static void signIn() {
	
	chromedriver.manage().deleteAllCookies();
	baseMethods.click(homePageLocators.signInButton);
	baseMethods.fn_sendKeys(homePageLocators.enterUserName, ExcelDataAccess.amazonUsername );
	baseMethods.click(homePageLocators.hitContinueButton);
	baseMethods.fn_sendKeys(homePageLocators.enterPass, ExcelDataAccess.amazonPassword);
	baseMethods.click(homePageLocators.hitSignInButton);

	}
}
