package com.ChrisMensing.AmazonSeleniumFramework.PageObjects.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators 
{
	
	@FindBy(id= "a-autoid-0-announce")
	public WebElement SignInButton;
	
	@FindBy(id= "twotabsearchtextbox")
	@CacheLookup
	public WebElement SearchBar;
	
	@FindBy(id= "nav-search-submit-text")
	@CacheLookup
	public WebElement SearchButton;
	
	@FindBy(id= "searchDropdownBox")
	@CacheLookup
	public WebElement SearchDropdown;
	
	@FindBy(id= "nav-cart")
	@CacheLookup
	public WebElement Cart;
	
	@FindBy(id= "nav-orders")
	@CacheLookup
	public WebElement OrdersLink;
	
	@FindBy(id= "nav-link-accountList")
	@CacheLookup
	public WebElement AccountDropDown;
	
	@FindBy(id= "nav-hamburger-menu")
	@CacheLookup
	public WebElement MainDropdown;
}
