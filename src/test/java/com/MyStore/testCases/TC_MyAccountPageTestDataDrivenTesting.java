package com.MyStore.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MyStore.pageObject.accountCreation;
import com.MyStore.pageObject.indexPage;
import com.MyStore.pageObject.myAccount;
import com.MyStore.pageObject.registerUserAccount;
import com.MyStore.utility.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDrivenTesting  extends BaseClass {

	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{	
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on signIn");
		
		myAccount pg1 = new myAccount(driver);
		pg1.enterEmail("atulb22061988@gmail.com");
		logger.info("Email entered");
		
		pg1.clickSubmitCreate();
		logger.info("Clicked on submit");
		
		accountCreation accCreationPg = new accountCreation(driver);
		
		accCreationPg.selectTitleMr();
		accCreationPg.enterFirstName("Atul");
		accCreationPg.enterLastName("Bunage");
		accCreationPg.enterpassword("22June1988");
		accCreationPg.enterAdd_firstName("Atul");
		accCreationPg.add_LastName("Bunage");
		accCreationPg.enteraddress("Murum/Baramati");
		accCreationPg.enterCity("Baramati");
		accCreationPg.enterState("Alabama");
		accCreationPg.enterPostcode("10000");
		accCreationPg.enterCountry("United States");
		accCreationPg.enterMobile("9588457209");
		accCreationPg.enterAlias("Home");
		
		logger.info("Entered User details");

		accCreationPg.clickOnRegister();
		
		logger.info("Clicked on Register");
		
		registerUserAccount regUser = new registerUserAccount(driver);

		String userName = regUser.getUserName();
		
		Assert.assertEquals("Atul Bunage", userName);
		
		logger.info("Assertion pass");
		
	}
	
	  @Test(dataProvider="LoginDataProvider")
	  public void verifyLogin(String userEmail,String userPwd,String expectedUserName)
	  {
		  indexPage pg = new indexPage(driver);
			pg.clickOnSignIn();
			logger.info("Clicked on signIn");
			
			myAccount pg1 = new myAccount(driver);
			pg1.enterEmailAdress(userEmail);
			logger.info("Entered email");

			pg1.enterPassword(userPwd);
			logger.info("Entered passsword");

			pg1.clickSubmit();
			logger.info("Clicked on Submit");

			
			registerUserAccount regUser = new registerUserAccount(driver);

			String userName = regUser.getUserName();
			if(userName.equals(expectedUserName))
			{
				logger.info("VerifyLogin -Passed");
				Assert.assertTrue(true);
				
				regUser.clickOnSignOut();
			}
			else
			{
				logger.info("VerifyLogin -failed");
				captureScreenShot(driver,"verifyLogin");
				Assert.assertTrue(false);
			}
    
	  }
	  
	  @DataProvider(name="LoginDataProvider")
	  public String[][]LoginDataProvider()
	  {
		  String fileName = System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
		  int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		  int ttlColums = ReadExcelFile.getColCount(fileName, "LoginTestData");
		  
		  String data[][] = new String[ttlRows-1][ttlColums];
		  
		  for(int i = 1;i<ttlRows;i++)
		  {
			  for(int j=0;j<ttlColums;j++)
			  {
				  data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
				  
			  }
			  
		  }

		  return data;
		  
		  
	  }
	  
}
