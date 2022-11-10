package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPaymentPage {
	
	WebDriver ldriver;

	//2.create constructor

	public orderPaymentPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	WebElement Paybycheck;
	
	@FindBy(className="bankwire")
	WebElement Paybybankwire;
	
	public void clickOnPaybycheck()
	{
		Paybycheck.click();
	}
	public void clickOnPaybybankwire()
	{
		Paybybankwire.click();
	}


}
