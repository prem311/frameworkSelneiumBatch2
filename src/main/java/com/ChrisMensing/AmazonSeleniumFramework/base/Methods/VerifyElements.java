package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyElements extends methodSuper 
{

	public void VerifyWebElements(WebElement actual, WebElement expected)
	{
		LogAction("Assert Two Elements", actual);
		Assert.assertEquals(actual, expected);	
	}
	
}
