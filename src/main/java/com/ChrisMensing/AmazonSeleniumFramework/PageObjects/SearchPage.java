package com.ChrisMensing.AmazonSeleniumFramework.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.PageSuper.PageType;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators.SearchPageLocators;

public class SearchPage extends PageSuper{
	SearchPageLocators SearchPageLocatorsObj;
	List<WebElement> ResultsOfSearch;
	
	public SearchPage(WebDriver DriverToUse) {
		Driver = DriverToUse;
		SearchPageLocatorsObj = new SearchPageLocators();
		PageFactory.initElements(Driver, SearchPageLocatorsObj);
		CurrentPageType = PageType.Search;
	}

	//Loops though and looks for the search term, and populates the ResultsOfSearch if a match is found. 
	public boolean Search(String SearchTerm, String SearchType)
	{
		if(SearchType.equals("No Results"))
		{
			FindResults(SearchType, SearchTerm);
			return !ResultsOfSearch.isEmpty();
		}
		
		boolean LastPage = false;
		while (!LastPage)
		{
			FindResults(SearchType, SearchTerm);
			if (!ResultsOfSearch.isEmpty())
			{
				return true;
			}
			if(!SearchPageLocatorsObj.LastButton.isEmpty())
			{
				LastPage = true;
			}
			else 
				{
					MethodToPreform.ClickOnWebElement(SearchPageLocatorsObj.NextButton);
				}
		}
				
		return false;
	}
	
	//Checks for the Search Item Spified
	public List<WebElement> FindResults(String SearchType, String SearchTerm) 
	{
		Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		switch (SearchType.toLowerCase()) {
		case "partiallinktext":
			ResultsOfSearch = Driver.findElements(By.partialLinkText(SearchTerm));
			break;
		case "linktext":
			ResultsOfSearch = Driver.findElements(By.linkText(SearchTerm));
			break;
		case "class":
			ResultsOfSearch = Driver.findElements(By.className(SearchTerm));
			break;
		case "name":
			ResultsOfSearch = Driver.findElements(By.name(SearchTerm));
			break;
		case "id":
			ResultsOfSearch = Driver.findElements(By.id(SearchTerm));
			break;
		case "css":
			ResultsOfSearch = Driver.findElements(By.cssSelector(SearchTerm));
			break;
		case "tag":
			ResultsOfSearch = Driver.findElements(By.tagName(SearchTerm));
			break;
		case "xpath":
			ResultsOfSearch = Driver.findElements(By.xpath(SearchTerm));
			break;
		case "no results":
			ResultsOfSearch = Driver.findElements(By.xpath("//*[text()[contains(., 'No results for')]]"));
			break;
		}
		
		return ResultsOfSearch;
	}
	public void SetProductSearchType(String ProductSearchType)
	{
		if (!ProductSearchType.equals("None")) {	
			String ParentByString = "span[data-component-type='s-filters-panel-view']"; 
			String ChildByString = ".//span[contains(text(),'"+ProductSearchType+"')]";
			By ByLoc = new ByChained (By.cssSelector(ParentByString),By.xpath(ChildByString)); 
			MethodToPreform.ClickOnWebElement(Driver.findElement(ByLoc));
		}
	}
	public void SetSubSearchType(String SubSearchType)
	{
		if (!SubSearchType.equals("None")) {
			String ParentByString = "span[data-component-type='s-filters-panel-view']"; 
			String ChildByString = ".//span[contains(text(),'"+SubSearchType+"')]";
			By ByLoc = new ByChained (By.cssSelector(ParentByString),By.xpath(ChildByString)); 
			MethodToPreform.ClickOnWebElement(Driver.findElement(ByLoc));
		}
	}
	public void SetAvgReviewStars(String NumberOfStars)
	{
		switch (NumberOfStars.toLowerCase())
		{
		case "Any":
			break;
		case "1 star":
			MethodToPreform.ClickOnWebElement(SearchPageLocatorsObj.Av1Star);
			break;
		case "2 star":
			MethodToPreform.ClickOnWebElement(SearchPageLocatorsObj.Av2Star);
			break;
		case "3 star":
			MethodToPreform.ClickOnWebElement(SearchPageLocatorsObj.Av3Star);
			break;
		case "4 star":
			MethodToPreform.ClickOnWebElement(SearchPageLocatorsObj.Av4Star);
			break;
		}
	}
	public void SetPrime()
	{
		MethodToPreform.ClickOnWebElement(SearchPageLocatorsObj.PrimeEligibleButton);
	}

	public void SetAdditionalSearchDetails(String AdditionalSearchDetails)
	{
		if (!AdditionalSearchDetails.equals("None")) {
			//This will set any other additional Search Details
			//TODO: Seperate the string by : so the user can add as many as they want
			String ParentByString = "span[data-component-type='s-filters-panel-view']"; 
			String ChildByString = ".//span[contains(text(),'"+AdditionalSearchDetails+"')]";
			By ByLoc = new ByChained (By.cssSelector(ParentByString),By.xpath(ChildByString)); 
			MethodToPreform.ClickOnWebElement(Driver.findElement(ByLoc));
		}
	}
	
	public List<WebElement> GetResultList()
	{
		return ResultsOfSearch;
	}
}
