package com.ChrisMensing.AmazonSeleniumFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class VerifyResults {
	
	@DataProvider(parallel = true, name = "ResultsTest")
	public static Object[][] getLoginTestDetails(){
	
		//TODO: Get a List of Test from the Constant vars Page Store 
		
		//TODO: Lookup Item Info from Excel Sheet
		
		//TODO: Pass Test Data back
		return null;
}

	
	@Test(dataProvider = "ResultsTest", dependsOnGroups = {"ResultsPrereq"})
	public void TestResults() {
		//TODO: From the Search Page Passed from the data provider click on the result
		
		//TODO: Check the Other data relating to the Item, such as price and so on. 
		
		//TODO: Store Page for Shopping Cart Test
	}

}
