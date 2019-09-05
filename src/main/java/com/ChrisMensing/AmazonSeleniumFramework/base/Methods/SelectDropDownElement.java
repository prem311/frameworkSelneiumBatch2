package com.ChrisMensing.AmazonSeleniumFramework.base.Methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownElement implements ITestAction {
	public Select select;
	private enum SelectMethod {VisableText, Value, Index}
	private SelectMethod CurrentMethod = null;
	private int DropdownInt = 0; 
	private String DropdownString = null;

	//Selects the element based on the visible text from the drop down
		public void fn_selectByVisibleText(String visisbleText)
		{
			CurrentMethod = SelectMethod.VisableText;
			DropdownString = visisbleText;
		}
		
		//Selects the element based on the value from the drop down
		public void fn_selectValue(String value)
		{
			CurrentMethod = SelectMethod.Value;
			DropdownString = value;
		}
		
		//Selects the element based on the index from the drop down
		public void fn_selectIndex(int value)
		{
			CurrentMethod = SelectMethod.Index;
			DropdownInt = value;
		}

		public Object Execute(WebElement WebElementToUse, Actions ActionToUse) {
			switch (CurrentMethod) {
			case Index:
				select = new Select(WebElementToUse);
				select.selectByIndex(DropdownInt);
				break;
			case Value:
				select = new Select(WebElementToUse);
				select.selectByValue(DropdownString);
				break;
			case VisableText:
				select = new Select(WebElementToUse);
				select.selectByVisibleText(DropdownString);
				break;
			default:
				break;
			
			}
			return null;
		}
	
}
