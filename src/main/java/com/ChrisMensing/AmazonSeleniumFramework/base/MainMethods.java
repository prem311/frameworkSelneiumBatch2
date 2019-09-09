package com.ChrisMensing.AmazonSeleniumFramework.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import com.ChrisMensing.AmazonSeleniumFramework.base.Methods.*;

//This is a Facade for the main Methods. 
public class MainMethods {

	public void ClickOnWebElement(WebElement ElementToClickOn) 
	{
		ClickAndMouseHandler ActionObj = new ClickAndMouseHandler();
		ActionObj.clickOnWebElement(ElementToClickOn);
	}
	
	public void DoubleClickOnWebElement(WebElement ElementToClickOn, Actions action)
	{
		ClickAndMouseHandler ActionObj = new ClickAndMouseHandler();
		ActionObj.doubleClickOnWebElement(ElementToClickOn, action);
	}
	
	public void RightClickOnWebElement(WebElement ElementToClickOn, Actions action)
	{
		ClickAndMouseHandler ActionObj = new ClickAndMouseHandler();
		ActionObj.RightClickOnWebElement(ElementToClickOn, action);
	}

	public void SendKeyPress(WebElement Element, CharSequence KeystoSend) 
	{
		ElementInputHandler ActionObj = new ElementInputHandler();
		ActionObj.SendKeys(Element, KeystoSend);
	}
	
	public String GetElementText(WebElement Element)
	{
		ElementDetails ActionObj = new ElementDetails();
		return ActionObj.GetWebElementText(Element).toString();
	}
	
	//Clears the data
	public  void fn_clear(WebElement Element)
	{
		ElementInputHandler ActionObj = new ElementInputHandler();
		ActionObj.ClearData(Element);
	}
	
	//Drag and drops the element
	public void dragAndDrop(WebElement Element, WebElement Element2, Actions action)
	{
		ClickAndMouseHandler ActionObj = new ClickAndMouseHandler();
		ActionObj.dragAndDrop(Element, Element2, action);
	}

	//Mouse hover on an element based on the target elment
	public void hoverMouseOverElement(WebElement Element, Actions action)
	{
		ClickAndMouseHandler ActionObj = new ClickAndMouseHandler();
		ActionObj.HoverMouseOverTarget(Element, action);
	}
	
	//Asserts two elements
	public void validateTwoElements(WebElement actual, WebElement expected) 
	{
		VerifyElements ActionObj = new VerifyElements();
		ActionObj.VerifyWebElements(actual, expected);
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
