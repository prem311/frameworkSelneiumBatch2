package com.chrisMensing.seleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chrisMensing.seleniumFramework.PageObjects.HomePage;
import com.chrisMensing.seleniumFramework.PageObjects.SearchPage;

import resources.DataProviders;

public class TestSearch{
	
	@DataProvider(parallel = false, name = "SearchTest")
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
		//HomePageObj.CloseDriver();
	}

}
 