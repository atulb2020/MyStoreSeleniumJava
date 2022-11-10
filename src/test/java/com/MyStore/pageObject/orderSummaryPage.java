package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderSummaryPage {
	
	WebDriver ldriver;

	//2.create constructor

	public orderSummaryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceedToCheckOut;
	
	public void clickOnProceedToCheckOut()
	{
		proceedToCheckOut.click();
	}


}
