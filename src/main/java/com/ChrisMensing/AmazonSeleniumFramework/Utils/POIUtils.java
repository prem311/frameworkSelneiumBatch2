package com.ChrisMensing.AmazonSeleniumFramework.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtils {

	private static String DirPath = "\\src\\main\\java\\resources\\";
	private String ExcelFileName = "TestData.xlsx";
	private XSSFSheet ExcelSheet;
    private XSSFWorkbook ExcelBook;
    Logger Log = Logger.getRootLogger();
	
    //Opens The excel File
	public void OpenExcelFile() 
	{
		try {
			Log.info("Opening Excel Workbook");
			DirPath = Paths.get(".").toAbsolutePath().normalize().toString() + DirPath;
			FileInputStream ExcelFile = new FileInputStream(DirPath+ExcelFileName);
			ExcelBook = new XSSFWorkbook(ExcelFile);
		}
		catch(Exception e)
		{
			Log.error("Error Trying to open excel file. Stack:", e);
		}
		
	}
	
	//The Constructor takes the file name and opens the excel file
	public POIUtils(String FileName)
	{
		ExcelFileName = FileName;
		if (ExcelBook == null) 
		{
			OpenExcelFile();
		}
	}
	
	//Get A value from the cell
	public Object GetCellValue(int RowNum, int CellNum) {
			XSSFRow RowOBJ = ExcelSheet.getRow(RowNum);
			if(RowOBJ == null) {
				ExcelSheet.createRow(RowNum);
				RowOBJ = ExcelSheet.getRow(RowNum);
			}
			XSSFCell CellOBJ = RowOBJ.getCell(CellNum, Row.CREATE_NULL_AS_BLANK);
			switch (CellOBJ.getCellType())
			{
			case Cell.CELL_TYPE_BLANK:
				return CellOBJ;
			case Cell.CELL_TYPE_NUMERIC:
				return CellOBJ.getNumericCellValue();
			case Cell.CELL_TYPE_STRING:
				return CellOBJ.getStringCellValue();
			case Cell.CELL_TYPE_FORMULA:
				return CellOBJ.getCellFormula();
			case Cell.CELL_TYPE_BOOLEAN:
				return CellOBJ.getBooleanCellValue();
			case Cell.CELL_TYPE_ERROR:
				return CellOBJ.getErrorCellValue();
				default: 
					return CellOBJ;
			}
	}
	
	//Sets a Cell String Value
	public void SetCellValue(int RowNum, int CellNum, String Value) {
			XSSFRow RowOBJ = ExcelSheet.getRow(RowNum);
			if(RowOBJ == null) {
				ExcelSheet.createRow(RowNum);
				RowOBJ = ExcelSheet.getRow(RowNum);
			}
			XSSFCell CellOBJ = RowOBJ.getCell(CellNum, Row.CREATE_NULL_AS_BLANK);
			CellOBJ.setCellValue(Value);
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream(DirPath + ExcelFileName);
				ExcelBook.write(fileOut);
				fileOut.flush();
				fileOut.close();
			} catch (FileNotFoundException e) {
				Log.error("File Not Found", e);
			} catch (IOException e) {
				Log.error("Error Trying to write to excel.", e);
			}

	}
	
	public int getLastRow() {
		return ExcelSheet.getLastRowNum();
	}
	
	public int getLastColumn(int RowToFind)
	{
		return ExcelSheet.getRow(RowToFind).getLastCellNum();
	}
	
	public int GetRowWithCellValue(String ValueToFind, int ColumnToSearch)
	{
		System.out.println(ValueToFind);
		for (Row row:ExcelSheet)
		{
			System.out.println(row.getCell(ColumnToSearch));
			if (row.getCell(ColumnToSearch).getStringCellValue().equals(ValueToFind))
			{
				return row.getRowNum();
			}
		}
		
		//If none where found throw Error
		//TODO: Add a custom Exception Here. 
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("No mathcing data found in Column: " + this);
		}
		return -1;
	}

	//This Opens the Tab
	public void setTab(String tab) {
		ExcelSheet = ExcelBook.getSheet(tab);
		if (ExcelSheet == null) 
		{
			ExcelBook.createSheet(tab);
			ExcelSheet = ExcelBook.getSheet(tab);
			Log.warn("Had to create a new sheet, if this was not intended stuff may break.");
		}
		
	}
	
}
