package com.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataAccess {

	public static String amazonUsername;
	public static String amazonPassword;
	
	public static void accessingExcelData(String datafilepath)throws Exception {
		
		String excelPropertyFilePath = System.getProperty("user.dir");
		
		File src = new File(excelPropertyFilePath + datafilepath);
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh1 = wb.getSheetAt(0);
		
		amazonUsername= sh1.getRow(0).getCell(0).getStringCellValue();
		amazonPassword = sh1.getRow(0).getCell(1).getStringCellValue();
		
	}
	
}
