package com.Amazon.test;

import org.testng.annotations.Test;

import com.amazon.base.baseTest;

import webPageActions.homePageActions;

import com.amazon.base.*;

import resources.ConstantVariables;


public class homePageTest {
	
	@Test
	public void AutomateAmazonLogin()throws Exception{
		
		baseTest object = new baseTest();
		ExcelDataAccess.accessingExcelData(ConstantVariables.excelFilePath);
		homePageActions.signIn();
		baseTest.closeBrowser();
	}
	
	
}
