package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownElement {
	public Select select;
	public enum SelectMethod {VisableText, Value}

		public void SelectDropdown(WebElement WebElementToUse, String SelectionValue, SelectMethod ChoosenSelectType) 
		{
			switch (ChoosenSelectType) {
			case Value:
				select = new Select(WebElementToUse);
				select.selectByValue(SelectionValue);
				break;
			case VisableText:
				select = new Select(WebElementToUse);
				select.selectByVisibleText(SelectionValue);
				break;
			default:
				break;
			}
		}
		
		public void SelectDropdown(WebElement WebElementToUse, int IndexValue) 
		{
			select = new Select(WebElementToUse);
			select.selectByIndex(IndexValue);
		}
	
}
