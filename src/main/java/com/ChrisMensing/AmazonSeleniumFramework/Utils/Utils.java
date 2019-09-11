package com.ChrisMensing.AmazonSeleniumFramework.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Utils {
	
	public enum OptionPaneType {YesNo, Text, Info}
	public static Logger log;
	
	private static Utils instanceObj;
	
	private Utils() 
	{

	}
	
	//Double check Locked Singleton, I am going to use this to control my file in/out as well. 
	public static Utils getInstance() 
	{
		if(instanceObj == null)
		{
			synchronized (Utils.class)
			{
				if (instanceObj == null)
				{
					instanceObj = new Utils();
					SetupLog4J();
					LoadConfig();
				}
			}
		}
		return instanceObj;
	}
	
	//A quick way to get input from the user. 
	public String DisplayOptionPane(String Message, String Title, OptionPaneType CurrentInputType)
	{
		
		//Creates a frame so on windows you can see the Message
		JFrame frame = new JFrame(Title);
        frame.setUndecorated( true );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        
        String ReturnValue = null;
		
        switch (CurrentInputType) 
        {
		case Info:
			break;
		case Text:
			//Ask the user the question
			ReturnValue = (String)JOptionPane.showInputDialog(
					frame, 
					Message,
					Title,
					JOptionPane.WARNING_MESSAGE,
					null, 
					null, 
					null);
			break;
		case YesNo:
			break;
		default:
			break;
        }
        
		//Closes the Frame
		frame.dispose();
		return ReturnValue; 
		
	}
	
	public static void SetupLog4J()
	{
		String path = "src/main/java/resources/log4j.properties";
		PropertyConfigurator.configure(path);
		log = Logger.getLogger(Utils.class);
	}

	//Loads the config File and initializes the constant vars
	public static void LoadConfig()
	{
		BufferedReader reader;
		if (ConstantVars.URL == null) {
			log.info("Init ConstantVars Class and Loading Properties");
			try {
				reader = new BufferedReader(new FileReader(ConstantVars.PropertyFilePath));
				ConstantVars.properties = new Properties();
				try {
					ConstantVars.properties.load(reader);
					log.info("Reading Config File");
					reader.close();
				} catch (final IOException e) {e.printStackTrace();}
			} catch (final FileNotFoundException e) {
				e.printStackTrace();
				log.fatal("Config.properties not found at " + ConstantVars.PropertyFilePath);
				throw new RuntimeException("Config.properties not found at " + ConstantVars.PropertyFilePath);
			}
			
			ConstantVars.URL =  ConstantVars.properties.getProperty("URL");
		}
	}
	
	public void SetTestDataSet (ArrayList<ArrayList<Object>> DataToPass)
	{
		
	}
	
}
