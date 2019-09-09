package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickAndMouseHandler extends methodSuper
{
	public void clickOnWebElement(WebElement WebElementToUse) 
	{
		WebElementToUse.click();
		LogAction("Click", WebElementToUse);
	}
	
	public void doubleClickOnWebElement(WebElement WebElementToUse, Actions ActionToUse) {
		ActionToUse.doubleClick(WebElementToUse).perform();
		LogAction("Double Click", WebElementToUse);
	}

	public void RightClickOnWebElement(WebElement WebElementToUse, Actions ActionToUse) {
		ActionToUse.contextClick(WebElementToUse).perform();
		LogAction("Right Click", WebElementToUse);
	}
	
	//Drag and drops the element
	public void dragAndDrop(WebElement WebElementToUse, WebElement WebElementToUse2, Actions action)
	{
		action.dragAndDrop(WebElementToUse, WebElementToUse2);
		LogAction("Drag and Drop", WebElementToUse);
	}

	//Hover the mouse over the target Element
	public void HoverMouseOverTarget(WebElement WebElementToUse, Actions action)
	{
		action.moveToElement(WebElementToUse);
		LogAction("Hover Mouse Over", WebElementToUse);
	}
	
	
	
	
	
}
