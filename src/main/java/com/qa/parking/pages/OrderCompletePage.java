package com.qa.parking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.ElementUtil;

public class OrderCompletePage extends BaseTest{
	private WebDriver driver;
	
	public OrderCompletePage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}

	By successmsg=By.xpath("//h1[contains(text(),'You’re all Booked! Thanks for parking with us!')]");
	By viewreservationbutton=By.xpath("//a[normalize-space()='View Reservation']");
	By licenseplatedetails=By.xpath("//span[normalize-space()='Test1600']");
	By startdateandtime=By.xpath("//p[normalize-space()='Jun. 21, 8:30PM']");
	By enddateandtime=By.xpath("//p[normalize-space()='Jun. 21, 10:30PM']");
	
	//Subscriptionsobject
	By successbanner=By.xpath("//span[@class='banner-title']");
	
	public String successmsgafterbooking() {
		elementutil.waitForElementWithFluentWait(successmsg, 20, 2);
		String statusmsg=elementutil.doGetText(successmsg);
//		elementutil.waitForElementPresent(licenseplatedetails, 20);
//		String licenseplatedetail=elementutil.doGetText(licenseplatedetails);
//		System.out.println(licenseplatedetail);
		return statusmsg;		
	}
	
	public void clickOnViewReservationButton() {
		elementutil.doClick(viewreservationbutton);
	}
	
	public void FetchSessionStartandEndTime() {
		elementutil.waitForElementPresent(startdateandtime, 30);
		String startdetails=elementutil.doGetText(startdateandtime);
		System.out.println("The start details of the session are : "+startdetails);
		String enddetails=elementutil.doGetText(enddateandtime);
		System.out.println("The end details of the session are : "+enddetails);
		
	}
	
	public String subscriptionsuccess() {
		elementutil.waitForElementWithFluentWait(successbanner, 20, 2);
		String banner=elementutil.doGetText(successbanner);
		return banner;
	}
	
}
