package com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SearchPageLocators {
	
	@FindBy(css= "li[class='a-last']")
	public WebElement NextButton;
	
	@FindAll(@FindBy(css="li[class='a-disabled a-last']"))
	public List <WebElement> LastButton;
	
	@FindBy(css= "i[aria-label='Prime Eligible']")
	public WebElement PrimeEligibleButton;
	
	@FindBy(css= "i[class='a-icon a-icon-star-medium a-star-medium-4']")
	public WebElement Av4Star;
	
	@FindBy(css= "i[class='a-icon a-icon-star-medium a-star-medium-3']")
	public WebElement Av3Star;
	
	@FindBy(css= "i[class='a-icon a-icon-star-medium a-star-medium-2']")
	public WebElement Av2Star;
	
	@FindBy(css= "i[class='a-icon a-icon-star-medium a-star-medium-1']")
	public WebElement Av1Star;
	
	@FindBy(id= "searchDropdownBox")
	public WebElement SearchType;
	
	
	@FindBy(css= "option[value='search-alias=stripbooks']")
	public WebElement SearchTypeBooks;
	
}
