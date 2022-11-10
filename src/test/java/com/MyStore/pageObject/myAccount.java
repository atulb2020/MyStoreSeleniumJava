package com.MyStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	
	// 1. create object of webdriver

		WebDriver ldriver;
		
		//2.create constructor

		public myAccount(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		
		//3.Identify webelements
		
		@FindBy(id="email_create")
		WebElement createEmailId;
		
		@FindBy(id="SubmitCreate")
		WebElement SubmitCreate;
		
		//Already Register User
		@FindBy(id="email")
		WebElement RegisteredUsersEmail;
		
		@FindBy(id="passwd")
		WebElement RegisteredUsersPwd;
		
		@FindBy(id="SubmitLogin")
		WebElement SubmitLogin;
		
		
		//4. Action methods
		
		public void enterEmail(String emailAdd)
		{
			createEmailId.sendKeys(emailAdd);
		}
		
		public void clickSubmitCreate()
		{
			SubmitCreate.click();	
		}
		
		// Action methods for Already Register User
		public void enterEmailAdress(String emailAdd)
		{
			RegisteredUsersEmail.sendKeys(emailAdd);
		}
		
		public void enterPassword(String pwd)
		{
			RegisteredUsersPwd.sendKeys(pwd);
		}
		
		public void clickSubmit()
		{
			SubmitLogin.click();	
		}


}
