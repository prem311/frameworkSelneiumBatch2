package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class methodSuper {
	Logger Log;
	
	public methodSuper()
	{
		//Logger Log = Logger.getRootLogger();
		
	}
	
	protected void LogAction (String ActionPreformed, WebElement PreformedOn)
	{
		//TODO: Fix Logger Error
		//Had to remove, For some reason I am getting a Null Error when trying to log this way. Will add back in later. I think I just need to Set a named Logger for this as well. 
		/*if (Log == null)
		{
			Logger Log = Logger.getRootLogger();
		}
		
		try 
		{
			Log.info("Action Preformed: " + ActionPreformed + ": On: " + PreformedOn.toString());
		} catch (Exception e)
		{
			Log.error("Error Occured When trying to log actions: " + this, e);
		}*/
	}
	

}
