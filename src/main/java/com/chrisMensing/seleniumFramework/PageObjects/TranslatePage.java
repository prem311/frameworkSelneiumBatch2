package com.chrisMensing.seleniumFramework.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.chrisMensing.seleniumFramework.PageObjects.pageLocators.TranslateLocators;

public class TranslatePage extends PageSuper{
	TranslateLocators translateLocatorsObj;
	
	public TranslatePage(String BrowserToOpen)
	{
		Driver = GetDriver(BrowserToOpen);
		Driver.get("https://translate.google.com/?hl=en&tab=wT0");
		translateLocatorsObj = new TranslateLocators();
		PageFactory.initElements(Driver, translateLocatorsObj);
	}
	
	public void EnterTextInSorce(String TextToTranslate)
	{
		MethodToPreform.SendKeyPress(translateLocatorsObj.TranslateSource, TextToTranslate);
	}
	
	public void SelectLanguage(String SourceLanguage, String TargetLanguage)
	{
		//As long as you pass the correct 2 Letter Lang Code this works IE GA for Irish 
		String SourcePathString = "//*[contains(@onclick,'sl_list_" + SourceLanguage.toLowerCase() + "')]";
		String TargePathString = "//*[contains(@onclick,'tl_list_" + TargetLanguage.toLowerCase() + "')]";
	
		//Checks to see if the selected Source Language is already selected and if not then sets it
		String SoruceToCheck = "language_list_item_wrapper language_list_item_wrapper-"+SourceLanguage.toLowerCase()+" item-selected";
		MethodToPreform.ClickOnWebElement(translateLocatorsObj.SourceLanguageList);
		WebElement SourceLangSelection = Driver.findElement(By.xpath(SourcePathString));
		System.out.println(SourceLangSelection.getAttribute("class") +":::"+ SoruceToCheck);
		if(SourceLangSelection.getAttribute("class").equals(SoruceToCheck))
		{
			MethodToPreform.ClickOnWebElement(translateLocatorsObj.SourceLanguageList);
		}
		else
		{
			
			MethodToPreform.ClickOnWebElement(SourceLangSelection);
		}
		//Checks to see if the selected Target Language is already selected and if not then sets it
		String TargetToCheck = "language_list_item_wrapper language_list_item_wrapper-"+TargetLanguage.toLowerCase()+" item-selected";
		MethodToPreform.ClickOnWebElement(translateLocatorsObj.TargetLanguageList);
		WebElement TargetLangSelection = Driver.findElement(By.xpath(TargePathString));
		System.out.println(TargetLangSelection.getAttribute("class") +":::"+ TargetToCheck);
		if(TargetLangSelection.getAttribute("class").equals(TargetToCheck))
		{
			MethodToPreform.ClickOnWebElement(translateLocatorsObj.TargetLanguageList);
		}
		else
		{
			MethodToPreform.ClickOnWebElement(TargetLangSelection);
		}
	}
	
	public String GetTranslation()
	{
		Driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Need to check if there is more than one span, and add them together, because Google likes making automation hard. :)
		int TranslatedSize = translateLocatorsObj.translated.size();
		if(TranslatedSize<2 && TranslatedSize >0)
		{
			return translateLocatorsObj.translated.get(0).getText();
		}
		else {
			String ReturnValue = "";
			for (WebElement i:translateLocatorsObj.translated)
			{
				if(ReturnValue == "") {ReturnValue = i.getText();}
				else 
				{
					ReturnValue = ReturnValue + " " + i.getText();
				}
			}
			return ReturnValue;
		}
	}

}
