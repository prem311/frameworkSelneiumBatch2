package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtils {

	private static String DirPath = "\\src\\main\\java\\resources\\";
	private static String ExcelFileName = "TestData.xlsx";
	private XSSFSheet ExcelSheet;
    private static XSSFWorkbook ExcelBook;
	
    //Opens 
	public static void OpenExcelFile() {
		try {
			DirPath = Paths.get(".").toAbsolutePath().normalize().toString() + DirPath;
			FileInputStream ExcelFile = new FileInputStream(DirPath+ExcelFileName);
			ExcelBook = new XSSFWorkbook(ExcelFile);
			
		}
		catch(Exception e){
		}
		
	}
	public POIUtils(String SheetName){
		if (ExcelBook == null) {
			OpenExcelFile();
		}
		ExcelSheet = ExcelBook.getSheet(SheetName);
		if (ExcelSheet == null) {
			ExcelBook.createSheet(SheetName);
			ExcelSheet = ExcelBook.getSheet(SheetName);
			}
	}
	
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public int getLastRow() {
		return ExcelSheet.getLastRowNum();
	}
	
}
