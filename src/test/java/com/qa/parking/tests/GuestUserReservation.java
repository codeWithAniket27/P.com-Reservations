package com.qa.parking.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.Constants;

public class GuestUserReservation extends BaseTest{
	
		@Test
		public void verifyTheGuestUserReservationFlow(){
			homepage_obj.searchForTheDesiredLocation(excelutil.ExcelutilsReadData("P.com", 1, 0));
			locationdetailspage_obj.clickOnBookParkingButton();
			checkoutpage_obj.enterCheckoutDetails(prop.getProperty("emailaddress"),excelutil.ExcelutilsReadData("P.com", 1, 1),excelutil.ExcelutilsReadData("P.com", 1, 2),excelutil.ExcelutilsReadData("P.com", 1, 3),excelutil.ExcelutilsReadData("P.com", 1, 4),excelutil.ExcelutilsReadData("P.com", 1, 5),excelutil.ExcelutilsReadData("P.com", 1, 6),excelutil.ExcelutilsReadData("P.com", 1, 7),excelutil.ExcelutilsReadData("P.com", 1, 8));
//			ordercompletepage_obj.FetchSessionStartandEndTime();
//			String msg=ordercompletepage_obj.successmsgafterbooking();
//			Assert.assertEquals(msg, Constants.STANDARD_RESERVATION_SUCCESS_MESSAGE);
		}
}
