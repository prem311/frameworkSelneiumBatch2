package com.ChrisMensing.AmazonSeleniumFramework.Utils;

import java.util.Properties;

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

}
