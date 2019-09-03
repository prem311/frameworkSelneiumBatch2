package com.amazon.base;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.base.baseTest;


public class baseMethods extends baseTest{
	
	static Actions action = new Actions(chromedriver);
	private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor)chromedriver;
	private static int invalidImageCount;
	
	//Clicks the required element
	public static void click(By elementLocator)
	{
		chromedriver.findElement(elementLocator).click();
	}
	
	//Gets the text of the element
	public static String getElementText(By elementLocator)
	{
		String txt =chromedriver.findElement(elementLocator).getText();
		return txt;
	}
	
	//Selects the element based on the visible text from the drop down
	public static void fn_selectByVisibleText(By elementLocator, String visisbleText)
	{
		Select select = new Select(chromedriver.findElement(elementLocator));
		select.selectByVisibleText(visisbleText);		
	}
	
	//Selects the element based on the value from the drop down
	public static void fn_selectValue(By elementLocator, String value)
	{
		Select select = new Select(chromedriver.findElement(elementLocator));
		select.selectByValue(value);	
	}
	
	//Selects the element based on the index from the drop down
	public static void fn_selectIndex(By elementLocator, int value)
	{
		Select select = new Select(chromedriver.findElement(elementLocator));
		select.selectByIndex(value);	
	}
	
	
	//Clears the data
	public static void fn_clear(By elementLocator)
	{
		chromedriver.findElement(elementLocator).clear();
	}
	
	//Enters the text in the text box
	public static void fn_sendKeys(By elementLocator, String keysToSend)
	{
		chromedriver.findElement(elementLocator).sendKeys(keysToSend);
	}
			
	//double clicks on the element
	public static void fn_doubleClick(By elementLocator)
	{
		action.doubleClick(chromedriver.findElement(elementLocator)).perform();
	}
	
	//Right clicks on the element/page
	public static void fn_contextMenu(By elementLocator)
	{
		action.contextClick(chromedriver.findElement(elementLocator)).perform();
	}

	
	//Uploads and image
	public static void isImageBroken()
	{
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = chromedriver.findElements(By.tagName("img"));
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
	
	//Drag and drops the element
	public static void dragAndDrop(By initialElementLocator, By targetElementLocator)
	{
		WebElement initialElement = chromedriver.findElement(initialElementLocator);
		WebElement targetElement = chromedriver.findElement(targetElementLocator);
		action.dragAndDrop(initialElement, targetElement);
		
	}

	//Mouse hover on an element based on the target elment
	public static void fn_mouseHOverTarget(By elementLocator)
	{
		WebElement mouseHoverElement = chromedriver.findElement(elementLocator);
		action.moveToElement(mouseHoverElement);
	}
	
	//Asserts two elements
	public static void fn_validateTwoElements(By expectedElementLocator, By actualElementLocator) 
	{
		String expected = chromedriver.findElement(expectedElementLocator).getText();
		String actual = chromedriver.findElement(actualElementLocator).getText();
		Assert.assertEquals(actual, expected);
	}
		
}
	


