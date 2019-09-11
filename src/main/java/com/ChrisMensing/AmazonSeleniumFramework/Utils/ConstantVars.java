package com.ChrisMensing.AmazonSeleniumFramework.Utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.PageSuper;

public class ConstantVars {
	//File paths
	public static final String DirPath = System.getProperty("user.dir");
	public static String PropertyFilePath = DirPath+"\\src\\main\\java\\resources\\config.properties";
	public static String ChromedriverExecutablePath = DirPath+ "\\src\\main\\java\\resources\\drivers\\chromedriver.exe";
	public static String IEdriverExecutablePath = DirPath+ "\\src\\main\\java\\resources\\drivers\\";
	public static String FireFoxdriverExecutablePath = DirPath+ "\\src\\main\\java\\resources\\drivers\\geckodriver.exe";

	//Other vars
	public static String URL;
	public static Properties properties;
	
	//This will allow me to store Page Objects and call them in another class
	private static Hashtable<PageSuper.PageType , ArrayList<Object>> PageStore = new Hashtable<PageSuper.PageType , ArrayList<Object>>();
	
	public static void StorePage(PageSuper.PageType PageTypeToStore, Object PageObjToStore)
	{
		ArrayList<Object> TempVar;
		//Checks if there is already a key present and if not creates a new ArrayList
		if(!PageStore.containsKey(PageTypeToStore)) 
		{
			TempVar = new ArrayList<Object>();
		}
		else
		{
			TempVar = PageStore.get(PageTypeToStore);
		}
		TempVar.add(PageObjToStore);
		PageStore.put(PageTypeToStore, TempVar);
	}
	
	public ArrayList<Object> GetPageObjects(PageSuper.PageType PageTypeToGet)
	{
		return PageStore.get(PageTypeToGet);
	}

}
