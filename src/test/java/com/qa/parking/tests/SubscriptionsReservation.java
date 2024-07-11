package com.qa.parking.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.parking.base.BaseTest;

public class SubscriptionsReservation extends BaseTest{
	
	@Test
	public void verifySubscriptionsFlowForLoggedInUser() {
		homepage_obj.clickOnLoginButton();
		loginpage_obj.doLogin(prop.getProperty("emailaddress"),prop.getProperty("password"));
		homepage_obj.searchForTheDesiredLocation(prop.getProperty("locationid"));
		locationdetailspage_obj.verifyMonthlyParkingSectionIsPresent();
		subscriptionsproductpage_obj.selectSubscriptionProduct();
		checkoutpage_obj.clickOnTncCheckBox();
		String actualstatus=ordercompletepage_obj.subscriptionsuccess();
		Assert.assertEquals(actualstatus, "SUCCESS");
	}

}
