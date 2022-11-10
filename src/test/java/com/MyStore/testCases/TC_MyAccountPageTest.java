package com.MyStore.testCases;

import org.testng.annotations.Test;

import com.MyStore.pageObject.accountCreation;
import com.MyStore.pageObject.indexPage;
import com.MyStore.pageObject.myAccount;
import com.MyStore.pageObject.registerUserAccount;

import junit.framework.Assert;

public class TC_MyAccountPageTest  extends BaseClass {

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
	
	  @Test(enabled=true)
	  public void verifyLogin()
	  {
		  indexPage pg = new indexPage(driver);
			pg.clickOnSignIn();
			logger.info("Clicked on signIn");
			
			myAccount pg1 = new myAccount(driver);
			pg1.enterEmailAdress("atulb22061988@gmail.com");
			logger.info("Entered email");

			pg1.enterPassword("Atul1234");
			logger.info("Entered passsword");

			pg1.clickSubmit();
			logger.info("Clicked on Submit");

			
			registerUserAccount regUser = new registerUserAccount(driver);

			String userName = regUser.getUserName();
			if(userName.equals("Atul Bunage"))
			{
				logger.info("VerifyLogin -Passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("VerifyLogin -failed");
				captureScreenShot(driver,"verifyLogin");
				Assert.assertTrue(false);
			}
 
	  }
	  @Test(enabled=true)
	  public void verifySignOut()
	  {
			logger.info("***************test case verify sign out Start********");

		  
		  indexPage pg = new indexPage(driver);
			pg.clickOnSignIn();
			logger.info("Clicked on signIn");
			
			myAccount pg1 = new myAccount(driver);
			pg1.enterEmailAdress("atulb22061988@gmail.com");
			logger.info("Entered email");

			pg1.enterPassword("Atul1234");
			logger.info("Entered passsword");

			pg1.clickSubmit();
			logger.info("Clicked on Submit");

			
			registerUserAccount regUser = new registerUserAccount(driver);
			regUser.clickOnSignOut();
			
			if(pg.getPageTitle().equals("Login - My Store"))
			{
				logger.info("verify signout - passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Verified signOut - failed");
				captureScreenShot(driver,"VerifySignOut");
				Assert.assertFalse(false);
			}
			logger.info("***************test case verify sign out ends********");

	  }
	  
}
