package com.ChrisMensing.AmazonSeleniumFramework.Utils;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DataProviders 
{
	protected static POIUtils ExcelUtils;
	static Logger Log = Logger.getRootLogger();
	//This gets all the Test data from the excel, Note, you must include 2 rows of excluded info in the excel for this method.  
	public static Object[][] getTestDetails(String FileName, String Tab)
	{
		return CreateReturnArray(GetExcelData(FileName, Tab, null));
	}
	
	//This is a overload so I can use test that refence other test.
	public static Object[][] getTestDetails(String FileName, String Tab, String SourceTab)
	{
		return CreateReturnArray(GetExcelData(FileName, Tab, SourceTab));
	}
	
	
	//Loops though the Excel Sheet. If Source Tab is null this will just go though the one tab
	private static ArrayList <ArrayList<Object>> GetExcelData(String FileName, String Tab, String SourceTab)
	{
		Log.info("Getting Test details from Excel.");
		ExcelUtils = new POIUtils(FileName);
		ExcelUtils.setTab(Tab);
		ArrayList <ArrayList<Object>> ReturnObjects = new ArrayList<ArrayList<Object>>();
		//Looping though The rows
		for(int i = 2; i < ExcelUtils.getLastRow()+1; i++) 
		{
			ArrayList <Object> InnerList = new ArrayList<Object>();
			
			//looping though the columns 
			for (int o = 0; o < ExcelUtils.getLastColumn(2); o++)
			{
				Object CellValue = ExcelUtils.GetCellValue(i, o);
				if (CellValue == null) 
				{
					//Do Nothing
				}
				else 
				{
					InnerList.add(CellValue);
				}
			}
			
			if (SourceTab != null)
			{
				InnerList.addAll(GetSourceData(FileName, SourceTab, ExcelUtils.GetCellValue(i, 1).toString()));
				ExcelUtils.setTab(Tab);
			}
			
			ReturnObjects.add(InnerList);
		}
		return ReturnObjects;
	}
	
	//Convert the ArrayList to Array
	private static Object[][] CreateReturnArray(ArrayList <ArrayList<Object>> ArrayListToConvert)
	{
			Object ReturnArray[][] = new Object[ArrayListToConvert.size()][];
			for (int i = 0; i < ArrayListToConvert.size(); i++)
			{
				ArrayList<Object> Row = ArrayListToConvert.get(i);
				ReturnArray[i] = Row.toArray();
			}
			return ReturnArray;
	}
	
	//This Looks 
	private static ArrayList<Object> GetSourceData(String FileName, String SourceTab, String NameToFind)
	{
		ExcelUtils.setTab(SourceTab);
		int RowNumber = ExcelUtils.GetRowWithCellValue(NameToFind, 0);
		ArrayList <Object> InnerList = new ArrayList <Object>();
		for (int o = 0; o < ExcelUtils.getLastColumn(2); o++)
		{
			Object CellValue = ExcelUtils.GetCellValue(RowNumber, o);
			if (CellValue == null) 
			{
				//Do Nothing
			}
			else 
			{
				InnerList.add(CellValue);
			}
		}
		return InnerList;
	}
}
