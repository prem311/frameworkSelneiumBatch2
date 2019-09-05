package com.chrisMensing.seleniumFramework.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.SearchPageLocators;

public class SearchPage extends PageSuper{
	SearchPageLocators SearchPageLocatorsObj;
	List<WebElement> ResultsOfSearch;
	
	public SearchPage(WebDriver DriverToUse) {
		Driver = DriverToUse;
		SearchPageLocatorsObj = new SearchPageLocators();
		PageFactory.initElements(Driver, SearchPageLocatorsObj);
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
		case "no results":
			ResultsOfSearch = Driver.findElements(By.partialLinkText("checking your spelling or use more general"));
			break;
		}
		
		return ResultsOfSearch;
	}
	

}
