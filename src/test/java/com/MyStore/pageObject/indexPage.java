package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	// 1. create object of webdriver

	WebDriver ldriver;
	
	//2.create constructor

	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//3.Identify webelements
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	//4. Action methods
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
	

}
