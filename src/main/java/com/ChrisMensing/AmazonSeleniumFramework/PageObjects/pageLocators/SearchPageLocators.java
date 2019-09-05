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
}
