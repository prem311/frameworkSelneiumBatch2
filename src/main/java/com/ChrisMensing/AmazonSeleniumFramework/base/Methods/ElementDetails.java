package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementDetails extends methodSuper
{
	public Object GetWebElementText(WebElement WebElementToUse) 
	{
		LogAction("Get Text", WebElementToUse);
		return WebElementToUse.getText();
	}
}
