package com.chrisMensing.seleniumFramework.base;

import java.util.ArrayList;
import java.util.Vector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import resources.ConstantVars;

public class WedDriverBuilder
{
		
	protected WebDriver Driver;
	public static Vector<WebDriver> Drivers = new Vector<WebDriver>();
	private static ArrayList<String>WindowHandles;
	
	public WedDriverBuilder(String BroswerToBuild) {
		System.out.println("Starting Broswer");
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
		ConstantVars init = new ConstantVars();
		System.out.println("Setting Up WebDriver Properties");
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
			System.out.println("Error Trying to switch Window Handles");
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
			System.out.println("Error Trying to switch Window Handles");
		}
	}

	
	
}
