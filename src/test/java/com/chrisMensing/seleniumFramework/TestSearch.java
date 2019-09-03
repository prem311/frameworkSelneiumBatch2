package com.chrisMensing.seleniumFramework;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.chrisMensing.seleniumFramework.PageObjects.HomePage;
import com.chrisMensing.seleniumFramework.base.TestSuper;

public class TestSearch extends TestSuper{

	@Test (dataProvider = "Test")
	public void SearchAscendum() 
	{
	
		HomePage HomePageObj = new HomePage("Chrome");
		HomePageObj.CheckAscendumSearch();
	}

}
 