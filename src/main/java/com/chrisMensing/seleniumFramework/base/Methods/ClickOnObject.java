package com.chrisMensing.seleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickOnObject implements ITestAction 
{
	public Object Execute(WebElement WebElementToUse, Actions ActionToUse) 
	{
		WebElementToUse.click();
		return WebElementToUse;
	}

}
