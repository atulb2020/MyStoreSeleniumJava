package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerUserAccount {

	WebDriver ldriver;

	//2.create constructor

	public registerUserAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(linkText="Sign out")
	WebElement signOut;
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement submitSearch;
	
	public void clickOnSignOut()
	{
		
		signOut.click();
	}

	public String getUserName()
	{
		String text = userName.getText();
		return text;
	}
	
	public void enterDataInSearchBox(String searchKey )
	{
		
		searchBox.sendKeys(searchKey);
	}
	
	public void clickOnSubmitSearch()
	{
		
		submitSearch.click();
	}


}
