package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderaddressPage {
	
	WebDriver ldriver;

	//2.create constructor

	public orderaddressPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="processAddress")
	WebElement addProceedToCheckOut;
	
	public void clickOnAddProceedToCheckOut()
	{
		addProceedToCheckOut.click();
	}


}
