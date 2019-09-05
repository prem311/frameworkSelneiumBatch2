package com.ChrisMensing.AmazonSeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.HomePage;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.SearchPage;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.DataProviders;



public class TestSearch{
	
	@DataProvider(parallel = true, name = "SearchTest")
	public static Object[][] getLoginTestDetails(){
		return DataProviders.getTestDetails("TestData.xlsx", "Searches", 4);
}

	@Test (dataProvider = "SearchTest")
	public void SearchAscendum(String Broswer, String SearchTerm, String ExpectedResult, String SearchType) 
	{
	
		HomePage HomePageObj = new HomePage(Broswer);
		HomePageObj.SearchTerm(SearchTerm);
		SearchPage SearchPageObj = new SearchPage(HomePageObj.GetDriver());
		Assert.assertTrue (SearchPageObj.Search(ExpectedResult, SearchType), "Result Not Found");
		HomePageObj.CloseDriver();
	}

}
 