package com.chrisMensing.seleniumFramework.PageObjects.pageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class TranslateLocators {
	
	@FindBy(id= "source")
	@CacheLookup
	public WebElement TranslateSource;
	
	@FindBy(className= "tl-more")
	@CacheLookup
	public WebElement TargetLanguageList;
	
	@FindBy(className= "sl-more")
	@CacheLookup
	public WebElement SourceLanguageList;
	
	@FindBy(xpath= "//*[contains(@onclick,'tl_list_ga')]")
	@CacheLookup
	public static WebElement IrishTL;
	
	@FindBy(xpath= "//*[contains(@onclick,'tl_list_la')]")
	@CacheLookup
	public WebElement LatinTL;
	
	@FindBy(xpath= "//*[contains(@onclick,'tl_list_en')]")
	@CacheLookup
	public WebElement EnglishTL;
	
	@FindBys(@FindBy(css= "span.tlid-translation.translation > span"))
	@CacheLookup
	public List<WebElement> translated;
	
}
