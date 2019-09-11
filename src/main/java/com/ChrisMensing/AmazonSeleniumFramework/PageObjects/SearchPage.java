package com.ChrisMensing.AmazonSeleniumFramework.PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.PageSuper.PageType;
import com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators.SearchPageLocators;
import com.ChrisMensing.AmazonSeleniumFramework.base.MainMethods;

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
			//FindResults(SearchType, SearchTerm);
			return !FindResults(SearchType, SearchTerm).isEmpty();
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
				WebDriverWait wait = new WebDriverWait(Driver, 5);
				MainMethods.ClickOnWebElement(wait.until(ExpectedConditions.elementToBeClickable(SearchPageLocatorsObj.NextButton)));
				wait = null;
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
			MainMethods.ClickOnWebElement(Driver.findElement(ByLoc));
			ByLoc = null;
		}
	}
	public void SetSubSearchType(String SubSearchType)
	{
		if (!SubSearchType.equals("None")) {
			String ParentByString = "span[data-component-type='s-filters-panel-view']"; 
			String ChildByString = ".//span[contains(text(),'"+SubSearchType+"')]";
			By ByLoc = new ByChained (By.cssSelector(ParentByString),By.xpath(ChildByString)); 
			MainMethods.ClickOnWebElement(Driver.findElement(ByLoc));
			ByLoc = null;
		}
	}
	public void SetAvgReviewStars(String NumberOfStars)
	{
		switch (NumberOfStars.toLowerCase())
		{
		case "Any":
			break;
		case "1 star":
			MainMethods.ClickOnWebElement(SearchPageLocatorsObj.Av1Star);
			break;
		case "2 star":
			MainMethods.ClickOnWebElement(SearchPageLocatorsObj.Av2Star);
			break;
		case "3 star":
			MainMethods.ClickOnWebElement(SearchPageLocatorsObj.Av3Star);
			break;
		case "4 star":
			MainMethods.ClickOnWebElement(SearchPageLocatorsObj.Av4Star);
			break;
		}
	}
	public void SetPrime()
	{
		MainMethods.ClickOnWebElement(SearchPageLocatorsObj.PrimeEligibleButton);
	}

	public void SetAdditionalSearchDetails(String AdditionalSearchDetails)
	{
		if (!AdditionalSearchDetails.equals("None")) {
			//This will set any other additional Search Details
			List<String> SearchDetails = new ArrayList<String>();
			
			if (AdditionalSearchDetails.contains(":N:"))
			{
				SearchDetails = Arrays.asList(AdditionalSearchDetails.split(":N:"));
			}
			else
			{
				SearchDetails.add(AdditionalSearchDetails);
			}
			
			for (String CurrentString: SearchDetails)
			{
				String ParentByString = "span[data-component-type='s-filters-panel-view']"; 
				String ChildByString = ".//span[contains(text(),'"+CurrentString+"')]";
				WebDriverWait wait = new WebDriverWait(Driver, 2);
				By ByLoc = new ByChained (By.cssSelector(ParentByString),By.xpath(ChildByString)); 
				MainMethods.ClickOnWebElement(wait.until(ExpectedConditions.elementToBeClickable(ByLoc)));
				wait = null;
				ByLoc = null;
			}
			SearchDetails = null;
			
			
		}
	}
	
	public List<WebElement> GetResultList()
	{
		return ResultsOfSearch;
	}
}
