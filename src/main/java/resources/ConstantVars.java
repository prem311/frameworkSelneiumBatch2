package resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public static BufferedReader reader;
	
	//Sets up Constant Vars
	public ConstantVars(){
		System.out.println("Init ConstantVars Class and Loading Properties");
		try {
			reader = new BufferedReader(new FileReader(PropertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				System.out.println("Reading Config File");
				reader.close();
			} catch (final IOException e) {e.printStackTrace();}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " + PropertyFilePath);
		}
		
		URL =  properties.getProperty("URL");

		//}
	}
	


}
