package com.qa.parking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.ElementUtil;

public class SubscriptionsProductPage extends BaseTest{
	WebDriver driver;
	
	public SubscriptionsProductPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	
	By surfaceproduct=By.xpath("//h4[normalize-space()='24/7 Surface']");
	By subscriptionproduct=By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div/div[2]/div/div[1]/div[3]");
	By nextmonthnavigation=By.xpath("//i[@class='fa fa-caret-right']");
	By checkoutbutton=By.xpath("//button[@id='goToCheckout']");
	By date=By.xpath("//div[normalize-space()='23']");
	
	public void selectSubscriptionProduct() {
		elementutil.waitForElementPresent(subscriptionproduct, 10);
		elementutil.doClick(subscriptionproduct);
		elementutil.doClick(checkoutbutton);
	}
}
