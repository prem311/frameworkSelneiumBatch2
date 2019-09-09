package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class methodSuper {
	Logger Log;
	
	methodSuper()
	{
		Logger Log = Logger.getRootLogger();
	}
	
	protected void LogAction (String ActionPreformed, WebElement PreformedOn)
	{
		
		Log.info("Action Preformed: " + ActionPreformed + ": On: " + PreformedOn.getTagName() + " : " + PreformedOn.toString());
	}
	

}
