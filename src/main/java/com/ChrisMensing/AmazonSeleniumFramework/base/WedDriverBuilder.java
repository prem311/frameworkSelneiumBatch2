package com.ChrisMensing.AmazonSeleniumFramework.base;

import java.util.ArrayList;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ChrisMensing.AmazonSeleniumFramework.Utils.ConstantVars;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.Utils;

public class WedDriverBuilder
{
		
	protected WebDriver Driver;
	public static Vector<WebDriver> Drivers = new Vector<WebDriver>();
	private static ArrayList<String>WindowHandles;
	private org.apache.log4j.Logger log = Logger.getRootLogger();
	
	public WedDriverBuilder(String BroswerToBuild) {
		log.info("Starting Broswer : " + BroswerToBuild);
		if(!System.getProperties().containsKey("webdriver.chrome.driver")) {GetProperties();}
		switch (BroswerToBuild.toLowerCase()) {
		case "chrome":
			this.Driver = new ChromeDriver();
		break;
		case "firefox":
			Driver = new FirefoxDriver();
		break;
		case "ie":
			Driver = new InternetExplorerDriver();
		break;
		default:
			break;
		}
		
	}

	public WebDriver GetBroswer() {
		Driver.manage().window().maximize();
		Driver.get(ConstantVars.URL);
		
		return this.Driver;
	}
	
	public void GetProperties() {
		Utils.getInstance();
		log.info("Setting Up WebDriver Properties");
		System.setProperty("webdriver.chrome.driver", ConstantVars.ChromedriverExecutablePath);
		System.setProperty("webdriver.ie.driver", ConstantVars.IEdriverExecutablePath);
		System.setProperty("webdriver.gecko.driver", ConstantVars.FireFoxdriverExecutablePath);
	}
	
	
	//Check Windows Handles
	public void SetWindowsHandles() 
	{
		WindowHandles = new ArrayList<String>(Driver.getWindowHandles());
	}
	
	//Get Window Handles
	public ArrayList<String> GetWindowHandles()
	{
		if (WindowHandles.isEmpty()) {SetWindowsHandles();}
		return WindowHandles;
	}
	
	//Switch Windows
	public void SwitchWindows(String WindowHandle) 
	{
		try {
			if (WindowHandles.isEmpty()) {SetWindowsHandles();}
			Driver.switchTo().window(WindowHandle);	
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error Trying to switch Window Handles");
		}
	}
	
	//Switch Windows if you know the location in the WindowHandle ArrayList
	public void SwitchWindows(int WindowHandlePos) 
	{
		try {
			if (WindowHandles.isEmpty()) {SetWindowsHandles();}
			Driver.switchTo().window(WindowHandles.get(WindowHandlePos));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error Trying to switch Window Handles");
		}
	}

	
	
}
