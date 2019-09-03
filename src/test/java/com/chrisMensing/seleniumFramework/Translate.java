package com.chrisMensing.seleniumFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.chrisMensing.seleniumFramework.PageObjects.TranslatePage;
import com.chrisMensing.seleniumFramework.base.TestSuper;

import resources.DataProviders;

public class Translate extends TestSuper
{
	
	@DataProvider(parallel = false, name = "TranslateTest")
	public static Object[][] getLoginTestDetails(){
		return DataProviders.getTestDetails("Translate", 5);
}

	@Test(dataProvider = "TranslateTest")
	public void TestTranslate(String Broswer, String SourceLanguage, String TargetLanguage, String TextToTranslate, String ExpectedResults)
	{
		TranslatePage TranslatePageObj = new TranslatePage(Broswer);
		TranslatePageObj.SelectLanguage(SourceLanguage,TargetLanguage);
		TranslatePageObj.EnterTextInSorce(TextToTranslate);
		String TranslatedText = TranslatePageObj.GetTranslation();
		Assert.assertEquals(TranslatedText, ExpectedResults, "The Translation Did Not match:");
		TranslatePageObj.CloseDriver();
	}
}
