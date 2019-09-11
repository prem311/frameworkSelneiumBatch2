package com.ChrisMensing.AmazonSeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.HomePage;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.SearchPage;
import com.ChrisMensing.AmazonSeleniumFramework.Utils.DataProviders;

public class VerifyFilteredSearches {

	//This is currently the only one I wouldn't run Parallel as it is a much bigger class. But it still runs and completes in about around 2 mins Parallel for the 3 included test
	@DataProvider(parallel = false, name = "FilteredSearchTest")
	public static Object[][] getLoginTestDetails(){
		DataProviders FilterSearchTestDetails = new DataProviders("TestData.xlsx");
		FilterSearchTestDetails.LoadSourceTabData("Filtered Searches");
		FilterSearchTestDetails.LoadAddtionalInfoFromTab("Product ID", 3, 0, 0, 3);
		Object[][] Test = FilterSearchTestDetails.getTestDetails();
		FilterSearchTestDetails = null;
		return Test;
}

	@Test (dataProvider = "FilteredSearchTest" , groups= {"ResultsPrereq"})
	public void FileteredSearch(
			//The following are from the Filtered Search
			String Testname,
			String Broswer,
			String SearchTerm,
			String ProductID,
			String ProductSearchType,
			String SubSearchType,
			Boolean SetPrime,
			String NumberOfStars,
			String AdditionalSearchDetails,
			Boolean ShouldResultBeFound,
			//The Next 5 are from the Simple Search
			String ItemName,
			String LocatorText,
			String ResultType
	) 
	{
	
		HomePage HomePageObj = new HomePage(Broswer);
		HomePageObj.SearchTerm(SearchTerm);
		SearchPage SearchPageObj = new SearchPage(HomePageObj.GetDriver());
		//I wanted to do this for this test to reduce as much as I can, although it did not make a huge difference
		HomePageObj = null;
		System.gc();
		
		//Set The filters
		SearchPageObj.SetProductSearchType(ProductSearchType);
		SearchPageObj.SetSubSearchType(SubSearchType);
		SearchPageObj.SetAvgReviewStars(NumberOfStars);
		if (SetPrime) {SearchPageObj.SetPrime();}
		SearchPageObj.SetAdditionalSearchDetails(AdditionalSearchDetails);
	
		Assert.assertTrue (SearchPageObj.Search(LocatorText, ResultType)||!ShouldResultBeFound, "Result Not Found");
		
		if (ResultType.equals("No Results")||!ShouldResultBeFound)
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
