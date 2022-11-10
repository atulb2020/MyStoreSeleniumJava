package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreation {
	
WebDriver ldriver;
	
	//2.create constructor

	public accountCreation(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 
	   @FindBy(id="id_gender1")
	   WebElement titileMr;
	   
	   @FindBy(id="customer_firstname")
	   WebElement firstName;
	   
	   @FindBy(id="customer_lastname")
	   WebElement lastName;
	   
	   @FindBy(id="passwd")
	   WebElement password;
	   
	   @FindBy(id="firstname")
	   WebElement add_firstName;
	   
	   @FindBy(id="lastname")
	   WebElement add_lastName;
	   
	   @FindBy(id="address1")
	   WebElement address1;
	   
	   @FindBy(id="city")
	   WebElement city;
	   
	   @FindBy(id="id_state")
	   WebElement state;
	   
	   @FindBy(id="postcode")
	   WebElement postcode;
	   
	   @FindBy(id="id_country")
	   WebElement country;
	   
	   @FindBy(id="phone_mobile")
	   WebElement mobile;

	   @FindBy(id="alias")
	   WebElement alias;
	   
	   @FindBy(id="submitAccount")
	   WebElement register;
	   
	   //Action methods
	   
	   public void selectTitleMr()
	   {
		   titileMr.click();
	   }
	   public void enterFirstName(String fname)
	   {
		   firstName.sendKeys(fname);
	   }
	   public void enterLastName(String lname)
	   {
		   lastName.sendKeys(lname);
	   }
	   public void enterpassword(String pwd)
	   {
		   password.sendKeys(pwd);
	   }
	   public void enterAdd_firstName(String fname)
	   {
		   add_firstName.clear();
		   add_firstName.sendKeys(fname);
	   }
	   public void add_LastName(String fname)
	   {
		   add_lastName.clear();
		   add_lastName.sendKeys(fname);
	   }
	   public void enteraddress(String address)
	   {
		   address1.clear();
		   address1.sendKeys(address);
	   }
	   public void enterCity(String cityName)
	   {
		   city.sendKeys(cityName);
	   }
	   public void enterState(String txt)
	   {
		   Select s = new Select(state);
		   s.selectByVisibleText(txt);
	   }
	   public void enterPostcode(String postcodeData)
	   {
		   postcode.sendKeys(postcodeData);
	   }
	   public void enterCountry(String text)
	   {
		   Select s = new Select(country);
		   s.selectByVisibleText(text);
	   }
	   public void enterMobile(String mobilephone)
	   {
		   mobile.sendKeys(mobilephone);
	   }
	   public void enterAlias(String text)
	   {
		   alias.clear();
		   alias.sendKeys(text);
	   }
	   public void clickOnRegister()
	   {
		   register.click();
	   }
	   







}
