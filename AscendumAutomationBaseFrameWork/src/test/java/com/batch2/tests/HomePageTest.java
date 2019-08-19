package com.batch2.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.batch2.base.BaseTest;

import pageActions.HomePageActions;

public class HomePageTest extends BaseTest {
	
	HomePageActions homepageactions = new HomePageActions();
	
	@Test
	public void validateHomepage() throws IOException {
		homepageactions.verifyHomePageElements();
		// Note: This is a sample one. Please implement the methods appropriately.
		//All of your test classes will be extending the BaseTest class that will have test set up and tear down methods
	}

}
	