package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productPage {
	
	WebDriver ldriver;

	//2.create constructor

	public productPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(name="Submit")
	WebElement addToCart;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement Proceed;
	
	public void selectQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	public void selectSize(String sizeType)
	{
		Select s = new Select(size);
		s.selectByVisibleText(sizeType);
	}
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	public void clickOnProceed()
	{
		Proceed.click();
	}


}
