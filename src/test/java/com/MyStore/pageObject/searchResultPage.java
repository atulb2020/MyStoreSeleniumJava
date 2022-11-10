package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResultPage {
	
	WebDriver ldriver;

	//2.create constructor

	public searchResultPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Faded Short Sleeve T-shirts")
	WebElement searchResultProduct;
	
	@FindBy(linkText="More")
	WebElement moreLink;
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
		
	}
	public void clickOnMoreLink()
	{
		moreLink.click();		
	}


}
