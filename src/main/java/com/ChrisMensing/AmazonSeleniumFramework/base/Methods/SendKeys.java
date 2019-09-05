package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SendKeys implements ITestAction{
	CharSequence KeysToSend;

	//This just sends the keys to the web element
	public void Execute(WebElement WebElementToUse , CharSequence newKeysToSend) 
	{
		WebElementToUse.sendKeys(newKeysToSend);
	}
	
	// You only need this if you are using the Execute that does not pass the Char Sequence
	public void SetKeysToSend(CharSequence newKeystoSend) 
	{
		KeysToSend = newKeystoSend;
	}

	//This clicks on the element then Sends the keys
	public Object Execute(WebElement WebElementToUse, Actions ActionToUse) {
		ActionToUse.sendKeys(WebElementToUse, KeysToSend);
		return KeysToSend;
	}

	
}
 