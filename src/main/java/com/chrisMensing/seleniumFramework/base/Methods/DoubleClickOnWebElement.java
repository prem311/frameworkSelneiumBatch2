package com.chrisMensing.seleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickOnWebElement implements ITestAction 
{
	@Override
	public Object Execute(WebElement WebElementToUse, Actions ActionToUse) {
		ActionToUse.doubleClick(WebElementToUse).perform();
		return null;
	}

}
