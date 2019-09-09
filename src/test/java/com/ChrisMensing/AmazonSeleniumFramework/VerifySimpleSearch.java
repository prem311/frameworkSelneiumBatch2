package com.ChrisMensing.AmazonSeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.HomePage;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.SearchPage;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.DataProviders;



public class VerifySimpleSearch{
	
	@DataProvider(parallel = true, name = "SearchTest")
	public static Object[][] getLoginTestDetails(){
		return DataProviders.getTestDetails("TestData.xlsx", "Simple Searches");
}

	@Test (dataProvider = "SearchTest" , groups= {"ResultsPrereq"})
	public void SearchAscendum(String TestName, String Broswer, String SearchTerm, String ResultLocatorValue, String ResultLocatorType) 
	{
	
		HomePage HomePageObj = new HomePage(Broswer);
		HomePageObj.SearchTerm(SearchTerm);
		SearchPage SearchPageObj = new SearchPage(HomePageObj.GetDriver());
		Assert.assertTrue (SearchPageObj.Search(ResultLocatorValue, ResultLocatorType), "Result Not Found");
		
		if (ResultLocatorType.equals("No Results"))
		{
			SearchPageObj.CloseDriver();
		}
		else
		{
			//TODO: Pass Object to Constant Vars to Store for results test
			SearchPageObj.StorePage();
		}
		
	}

}
 