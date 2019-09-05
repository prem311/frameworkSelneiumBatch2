package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GetElementText implements ITestAction
{
	public Object Execute(WebElement WebElementToUse, Actions ActionToUse) {
		return WebElementToUse.getText();
	}
}
