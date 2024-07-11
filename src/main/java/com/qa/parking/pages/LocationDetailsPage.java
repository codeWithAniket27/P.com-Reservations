package com.qa.parking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.ElementUtil;

public class LocationDetailsPage extends BaseTest{
	
private WebDriver driver;
	
	public LocationDetailsPage(WebDriver driver) {
		this.driver=driver;
		elementutil = new ElementUtil(this.driver);
	}
	
	//Object Repository
	By Bookparkingbutton=By.xpath("//button[normalize-space()='Book Parking']");
	By orderprice=By.xpath("//div//strong//span[contains(text(),'$')]");
	By viewmoredetailsbutton=By.xpath("//a[normalize-space()='View More Details']");
	
	//Action Methods
	public void clickOnBookParkingButton() {
		elementutil.waitForElementPresent(orderprice, 30);
		System.out.println("The order price of the booking is : "+elementutil.doGetText(orderprice));
		elementutil.doClick(Bookparkingbutton);
	}
	
	public void verifyMonthlyParkingSectionIsPresent() {
		elementutil.waitForElementPresent(viewmoredetailsbutton, 20);	
		elementutil.doClick(viewmoredetailsbutton);
	}

}
