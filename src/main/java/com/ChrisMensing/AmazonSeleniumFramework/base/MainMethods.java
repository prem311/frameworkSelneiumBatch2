package com.ChrisMensing.AmazonSeleniumFramework.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import com.ChrisMensing.AmazonSeleniumFramework.base.Methods.*;

//Basically this is the invoker of a Command Design Pattern, to create many commands, this also allows me to setup the base framework and allow others to add more methods without changing old ones. 
public class MainMethods {
	
	public void MainMethods()
	{
		//TODO: Set Receiver 
		
	}
	
	public void ClickOnWebElement(WebElement ElementToClickOn) 
	{
		ITestAction ActionToPreform = new ClickOnObject();
		ActionToPreform.Execute(ElementToClickOn, null);
	}
	
	public void DoubleClickOnWebElement(WebElement ElementToClickOn, Actions action)
	{
		ITestAction ActionToPreform = new DoubleClickOnWebElement();
		ActionToPreform.Execute(ElementToClickOn, action);
	}
	
	public void RightClickOnWebElement(WebElement ElementToClickOn, Actions action)
	{
		ClickOnObject ActionToPreform = new ClickOnObject();
		ActionToPreform.Execute(ElementToClickOn, action);
	}

	
	public void SendKeyPress(WebElement Element, CharSequence KeystoSend) 
	{
		SendKeys ActionToPreform = new SendKeys();
		ActionToPreform.Execute(Element, KeystoSend);
	}
	
	public String GetElementText(WebElement Element)
	{
		ITestAction ActionToPreform = new GetElementText();
		return ActionToPreform.Execute(Element, null).toString();
	}
	
	//Clears the data
	public static void fn_clear(WebElement Element)
	{
		Element.clear();
	}
	
	//Drag and drops the element
	public static void dragAndDrop(WebElement Element, WebElement Element2, Actions action)
	{
		action.dragAndDrop(Element, Element);
	}

	//Mouse hover on an element based on the target elment
	public static void fn_mouseHOverTarget(WebElement Element, Actions action)
	{
		action.moveToElement(Element);
	}
	
	//Asserts two elements
	public static void fn_validateTwoElements(WebElement actual, WebElement expected) 
	{
		Assert.assertEquals(actual, expected);
	}

	
	//TODO: Implement these and test them
	/*
	//finds the text present on the webpage - uses the enums for the 
	public static void fn_isElementPresent(WebElement ElementToClickOn, ConstantVariables.elementPresent enumLocator)
	{
		switch(enumLocator)
		{
		case ISDISPLAYED: ElementToClickOn.isDisplayed();
		System.out.println("Yes");
		break;
		
		case ISENABLED: ElementToClickOn.isEnabled();
		System.out.println("No");
		break;
		
		case ISSELCTED: ElementToClickOn.isSelected();
		System.out.println("Three");
		break;
		
		}
	}

	//Scrolls the page to left, right, top, bottom based on the method called for
	public static void fn_scrollPage(ConstantVariables.pageScroll enumLocator)
	{
		switch(enumLocator)
		{
		case DOWN: javascriptExecutor.executeScript("window.scrollBy(0,250)");
		break;
		
		case UP: javascriptExecutor.executeScript("window.scrollBy(0,-250)");
		break;
		
		case TILLBOTTOMOFPAGE: javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		break;
		
		case TILLTOPOFPAGE: javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		break;
		
		case LEFT:  javascriptExecutor.executeScript("window.scrollBy(250,0)", "");
		break;
			
		case RIGHT: javascriptExecutor.executeScript("window.scrollBy(0,250)", "");
		break;
		}
	}
	
	//Uploads and image
	public static void isImageBroken()
	{
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	//Verifies active images
	public static void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	
	
	
}
