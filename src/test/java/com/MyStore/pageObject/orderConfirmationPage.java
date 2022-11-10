package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderConfirmationPage {
	
	WebDriver ldriver;

	//2.create constructor

	public orderConfirmationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")
	WebElement confirmOrder;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement successAlert;
	
	@FindBy(linkText="Sign out")
	WebElement SignOut;
	
	public void clickOnConfirmOrder()
	{
		confirmOrder.click();
	}
	public String getTextSuccessAlert()
	{
		return(successAlert.getText());	
	}
	public void clickOnSignOut()
	{
		SignOut.click();
	}


}
