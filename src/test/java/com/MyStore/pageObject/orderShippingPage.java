package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderShippingPage {
	
	WebDriver ldriver;

	//2.create constructor

	public orderShippingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="cgv")
	WebElement termsCheckBox;
	
	@FindBy(name="processCarrier")
	WebElement processCarrier;
	
	public void clickOnTermsCheckBox()
	{
		termsCheckBox.click();
	}
	public void clickOnProcessCarrier()
	{
		processCarrier.click();
	}


}
