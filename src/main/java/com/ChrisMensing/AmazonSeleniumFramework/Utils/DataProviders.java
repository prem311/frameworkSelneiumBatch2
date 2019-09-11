package com.ChrisMensing.AmazonSeleniumFramework.Utils;

import java.util.ArrayList;

import org.apache.log4j.Logger;


/*
 * I set this up so I can load info for data providers fairly easily, Please keep in mind however, will take at least two steps. 
 * 		1. Load info Source Tab, or pass in an ArrayList <ArrayList<Object>> of test
 * 		2. Optional: Add additional Tabs to the data set
 *   	3. Convert Data Set to Object[][]
 */
public class DataProviders 
{
	protected static POIUtils ExcelUtils;
	static Logger Log = Logger.getRootLogger();
	private ArrayList <ArrayList<Object>> DataSet;

	
	//Starts up the Data Provider and Excel Sheet
	public DataProviders(String FileName) 
	{
		ExcelUtils = new POIUtils(FileName);
		DataSet = new ArrayList <ArrayList<Object>>();
	}
	
	//This Allows me to pass in a data set if I create it from somewhere else. IE from another set of test
	public void SetDataSet(ArrayList<ArrayList<Object>> NewDataSet)
	{
		Log.info("Setting Dataset in DataProvider");
		DataSet = NewDataSet;
	}
	
	//Get Data from main spread sheet, This loads all the data across the columns
	public void LoadSourceTabData (String Tab)
	{
		ExcelUtils.setTab(Tab);
		LoadSourceTabData(Tab,0,ExcelUtils.getLastColumn(2));
	}
	//Get Data from main spread sheet, This loads columns all the columns included inbetween the Ints
	public void LoadSourceTabData (String Tab, int StartingColumn, int EndingColumn)
	{
		Log.info("Getting Source Test details from Excel.");
		ExcelUtils.setTab(Tab);
	
		//Looping though The rows
		for(int i = 2; i < ExcelUtils.getLastRow()+1; i++) 
		{
			ArrayList <Object> InnerList = new ArrayList<Object>();
			
			//looping though the columns 
			for (int o = StartingColumn; o < EndingColumn; o++)
			{
				Object CellValue = ExcelUtils.GetCellValue(i, o);
				if (CellValue == null) 
				{
					Log.warn("For Some reason the Excel Sheet returned a null value for cell at: " + i + ":" + 0 + " This will just inseart a blank value.");
					InnerList.add("");
				}
				else 
				{
					InnerList.add(CellValue);
				}
			}
			DataSet.add(InnerList);
		}
	}
	
	//Add in data from as many sources as the user sets based on a relation key IE Column in Sheet A Refs Column in Sheet B, This one loads all All Data
	public void LoadAddtionalInfoFromTab(String AddtionalInfoTab, int SourceKeyColumnNum, int MatchKeyCoulmnNum) 
	{
		ExcelUtils.setTab(AddtionalInfoTab);
		LoadAddtionalInfoFromTab(AddtionalInfoTab, SourceKeyColumnNum, MatchKeyCoulmnNum,0,ExcelUtils.getLastColumn(2));
	}
	
	//Add in data from as many sources as the user sets based on a relation key IE Column in Sheet A Refs Column in Sheet B, This one loads Columns between StartingColumn and EndingColumn
	public void LoadAddtionalInfoFromTab(String AddtionalInfoTab, int SourceKeyColumnNum, int MatchKeyCoulmnNum,int StartingColumn, int EndingColumn) 
	{
		Log.info("Getting Addition Test Details from Excel tab: " +AddtionalInfoTab);
		ExcelUtils.setTab(AddtionalInfoTab);
		//Loop Though the info loaded from the source tab
		for (ArrayList<Object> CurrentRow :DataSet)
		{
			String SourceKey = (String) CurrentRow.get(SourceKeyColumnNum);
			if(!SourceKey.toLowerCase().equals("n/a"))
			{				
				int RowNumber = ExcelUtils.GetRowWithCellValue(SourceKey, MatchKeyCoulmnNum);
				for (int o = StartingColumn; o < EndingColumn; o++)
				{
					Object CellValue = ExcelUtils.GetCellValue(RowNumber, o);
					if (CellValue == null) 
					{
						Log.warn("For Some reason the Excel Sheet returned a null value for cell at: " + RowNumber + ":" + 0 + " This will just inseart a blank value.");
						CurrentRow.add("");
					}
					else 
					{
						CurrentRow.add(CellValue);
					}
				}
			}
		}
	}
	
	
	//This returns all the test Data Setup by the other methods in this class
	public Object[][] getTestDetails()
	{
		System.gc();
		return CreateReturnArray();
	}
	
	
	//Convert the ArrayList to Array
	private Object[][] CreateReturnArray()
	{
			Object ReturnArray[][] = new Object[DataSet.size()][];
			for (int i = 0; i < DataSet.size(); i++)
			{
				ArrayList<Object> Row = DataSet.get(i);
				ReturnArray[i] = Row.toArray();
			}
			return ReturnArray;
	}
}
