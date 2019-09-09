package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementInputHandler extends methodSuper{

	//This just sends the keys to the web element
	public void SendKeys(WebElement WebElementToUse, CharSequence newKeysToSend) 
	{
		WebElementToUse.sendKeys(newKeysToSend);
		LogAction("Send Keys: " + newKeysToSend, WebElementToUse);
	}
	
	//This clicks on the element then Sends the keys
	public void ClickThenSendKeys(WebElement WebElementToUse, Actions ActionToUse, CharSequence newKeysToSend) 
	{
		ActionToUse.sendKeys(WebElementToUse, newKeysToSend);
		LogAction("Click Then Send Keys: " + newKeysToSend, WebElementToUse);
	}
	
	public void ClearData (WebElement WebElementToUse) 
	{
		WebElementToUse.clear();
		LogAction("Clear", WebElementToUse);
	}
}
 