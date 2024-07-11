package com.qa.parking.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.Constants;

public class LoggedInUserReservation extends BaseTest{
	
	@Test
	public void verifyLoggedInUserReservationFlow() {
		homepage_obj.clickOnLoginButton();
		loginpage_obj.doLogin(prop.getProperty("emailaddress"),prop.getProperty("password"));
		homepage_obj.searchForTheDesiredLocation(prop.getProperty("locationid"));
		locationdetailspage_obj.clickOnBookParkingButton();
		checkoutpage_obj.verifyCheckoutDetailsForLoggedInUser();
		String msg=ordercompletepage_obj.successmsgafterbooking();
		Assert.assertEquals(msg, Constants.STANDARD_RESERVATION_SUCCESS_MESSAGE);
	}

}
