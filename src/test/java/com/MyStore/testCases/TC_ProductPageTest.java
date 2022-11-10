package com.MyStore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyStore.pageObject.indexPage;
import com.MyStore.pageObject.myAccount;
import com.MyStore.pageObject.orderConfirmationPage;
import com.MyStore.pageObject.orderPaymentPage;
import com.MyStore.pageObject.orderShippingPage;
import com.MyStore.pageObject.orderSummaryPage;
import com.MyStore.pageObject.orderaddressPage;
import com.MyStore.pageObject.productPage;
import com.MyStore.pageObject.registerUserAccount;
import com.MyStore.pageObject.searchResultPage;

public class TC_ProductPageTest extends BaseClass {
	
	@Test(enabled=true)
	public void verifySearchProduct()
	{
		String searchKey ="T-shirts";
		logger.info("........Start verify search product page test.....");
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on signIn");
		
		myAccount pg1 = new myAccount(driver);
		pg1.enterEmailAdress(emailAddress);
		logger.info("Entered email");

		pg1.enterPassword(password);
		logger.info("Entered passsword");

		pg1.clickSubmit();
		logger.info("Clicked on Submit");

		registerUserAccount ua = new registerUserAccount(driver);
		ua.enterDataInSearchBox(searchKey);
		ua.clickOnSubmitSearch();
		
		searchResultPage rp = new searchResultPage(driver);
		String resultProductName=rp.getSearchResultProductName();
		
		if(resultProductName.contains(searchKey))
		{
			logger.info("Verify search product test - passed");
			Assert.assertTrue(true);
			ua.clickOnSignOut();
		}
		else
		{
			logger.info("Verify search product test - failed");
			captureScreenShot(driver,"verifySearchProduct");
			Assert.assertFalse(false);
		}
		logger.info("........End product page test.....");
	}
	
	@Test(enabled=true)
	public void verifyBuyProduct()
	{
		logger.info("************Testcase verify Buy Product end ***********");

		String searchKey ="T-shirts";
		
        indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on signIn");
		
		myAccount pg1 = new myAccount(driver);
		pg1.enterEmailAdress(emailAddress);
		logger.info("Entered email");

		pg1.enterPassword(password);
		logger.info("Entered passsword");

		pg1.clickSubmit();
		logger.info("Clicked on Submit");

		registerUserAccount ua = new registerUserAccount(driver);
		ua.enterDataInSearchBox(searchKey);
		ua.clickOnSubmitSearch();
		logger.info("Clicked on submitSearch");
		
		searchResultPage rp = new searchResultPage(driver);
		rp.clickOnMoreLink();
		logger.info("Clicked on moreLink");
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productPage productp = new productPage(driver);
		productp.selectQuantity("2");
		logger.info("Select quantity");

		productp.selectSize("M");
		logger.info("Select size");
		
		productp.clickOnAddToCart();
		logger.info("Clicked on add to card");

		productp.clickOnProceed();
		logger.info("Clicked on proceed");
		
		orderSummaryPage summaryP = new orderSummaryPage(driver);
		summaryP.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed");
		
		orderaddressPage addPage = new orderaddressPage(driver);
		addPage.clickOnAddProceedToCheckOut();
		logger.info("Clicked on proceed");

		orderShippingPage shipPage = new orderShippingPage(driver);
		shipPage.clickOnTermsCheckBox();
		logger.info("Clicked on term check box");

		shipPage.clickOnProcessCarrier();
		logger.info("Clicked on proceed");
		
		orderPaymentPage payPage = new orderPaymentPage(driver);
		payPage.clickOnPaybycheck();
		logger.info("Clicked on pay by checked");
		
		orderConfirmationPage confPage = new orderConfirmationPage(driver);
		confPage.clickOnConfirmOrder();
		logger.info("Clicked on confirmed order");
		
		String successAlert = confPage.getTextSuccessAlert();
		
		if(successAlert.equals("Your order on My Store is complete."))
		{
			logger.info("VerifyBuyProduct-passed");
			Assert.assertTrue(true);
			confPage.clickOnSignOut();
		}
		else
		{
			logger.info("VerifyBuyProduct-failed");
			captureScreenShot(driver,"verifySearchProduct");
			Assert.assertFalse(false);

		}
		
		logger.info("************Testcase verify Buy Product end ***********");




		


		
	}

}
