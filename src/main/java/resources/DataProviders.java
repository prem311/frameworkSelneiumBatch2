package resources;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//This gets all the Test data from the excel, Note, you must include 2 rows of excluded info in the excel for this method.  
	public static Object[][] getTestDetails(String Tab, int NumOfColumns)
	{
		System.out.println("Getting Test details from Excel.");
		POIUtils ExcelUtils = new POIUtils(Tab);
		ArrayList <ArrayList<Object>> ReturnObjects = new ArrayList<ArrayList<Object>>();
		//Looping though The rows
		System.out.println(ExcelUtils.getLastRow());
		for(int i = 2; i < ExcelUtils.getLastRow()+1; i++) 
		{
			ArrayList <Object> InnerList = new ArrayList<Object>();
			//looping though the columns 
			for (int o = 0; o < NumOfColumns; o++)
			{
				Object CellValue = ExcelUtils.GetCellValue(i, o);
				if (CellValue == null) 
				{
					System.out.println("Null Cell");
				}
				else 
				{
					InnerList.add(CellValue);
					System.out.println("Added Cell");
				}
			}
			ReturnObjects.add(InnerList);
		}
		
		//Convert the ArrayList to Array
		Object ReturnArray[][] = new Object[ReturnObjects.size()][];
		for (int i = 0; i < ReturnObjects.size(); i++)
		{
			ArrayList<Object> Row = ReturnObjects.get(i);
			System.out.println("Added Row to array");
			ReturnArray[i] = Row.toArray();
		}
		return ReturnArray;
	}
}
