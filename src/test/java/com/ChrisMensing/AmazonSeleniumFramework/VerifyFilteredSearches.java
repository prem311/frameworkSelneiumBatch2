package com.ChrisMensing.AmazonSeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.HomePage;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.SearchPage;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.DataProviders;

public class VerifyFilteredSearches {

	@DataProvider(parallel = true, name = "FilteredSearchTest")
	public static Object[][] getLoginTestDetails(){
		//TODO: Split this up a little more so I can  filter data better and with less work
		return DataProviders.getTestDetails("TestData.xlsx","Filtered Searches","Simple Searches");
}

	@Test (dataProvider = "FilteredSearchTest" , groups= {"ResultsPrereq"})
	public void FileteredSearch(
			//The following are from the Filtered Search
			String Testname,
			String RefToSimpleSearch,
			String ProductSearchType,
			String SubSearchType,
			Boolean SetPrime,
			String NumberOfStars,
			String AdditionalSearchDetails,
			Boolean ShouldResultBeFound,
			//The Next 5 are from the Simple Search
			String SimpleSearchTestName,
			String Broswer,
			String SearchTerm,
			String ResultLocatorValue,
			String ResultLocatorType
	) 
	{
	
		HomePage HomePageObj = new HomePage(Broswer);
		HomePageObj.SearchTerm(SearchTerm);
		SearchPage SearchPageObj = new SearchPage(HomePageObj.GetDriver());
		
		//Set The filters
		SearchPageObj.SetProductSearchType(ProductSearchType);
		SearchPageObj.SetSubSearchType(SubSearchType);
		SearchPageObj.SetAvgReviewStars(NumberOfStars);
		if (SetPrime) {SearchPageObj.SetPrime();}
		SearchPageObj.SetAdditionalSearchDetails(AdditionalSearchDetails);
	
		Assert.assertTrue (SearchPageObj.Search(ResultLocatorValue, ResultLocatorType)||!ShouldResultBeFound, "Result Not Found");
		
		if (ResultLocatorType.equals("No Results")||!ShouldResultBeFound)
		{
			SearchPageObj.CloseDriver();
		}
		else
		{
			//TODO: Pass Object for results if Results is found
			SearchPageObj.StorePage();
		}
		
	}
	
}
