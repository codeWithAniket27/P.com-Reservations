package com.qa.parking.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.ElementUtil;

public class HomePage extends BaseTest{
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil = new ElementUtil(this.driver);
		prop=new Properties();
	}
	
	//Object Repository
	By Signupbutton= By.xpath("//a[normalize-space()='Sign up']");
	By Loginbutton=By.xpath("//a[normalize-space()='Login']");
	By Dailytab=By.xpath("//a[normalize-space()='Daily']");
	By Monthlytab=By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/a[2]");
	By Locationsearchtext=By.xpath("//input[@id='txtsearch']");
	By Locationresult=By.xpath("//span//div//span//div//div[1]");
	By myaccountlink=By.xpath("//a[normalize-space()='My account']");
	By myprofileoption=By.xpath("//a[normalize-space()='Profile']");
	By paymentmethodsoption=By.xpath("//a[contains(@class,'dropdown-item')][normalize-space()='Payment Methods']");
	By vehicleoption=By.xpath("//a[contains(@class,'dropdown-item')][normalize-space()='Vehicles']");
	By monthlyparkingoption=By.xpath("//a[contains(@class,'dropdown-item')][normalize-space()='Monthly Parking']");
	By parkingsessionsoption=By.xpath("//a[contains(@class,'dropdown-item')][normalize-space()='Parking Sessions']");
	By favoritesoption=By.xpath("//a[contains(@class,'dropdown-item')][normalize-space()='Favorites']");
	By signoutoption=By.xpath("//a[contains(@class,'dropdown-item highlight red nav-sign-out')]");
	
	//Action Methods
	public void searchForTheDesiredLocation(String locationid) {
//		WebElement locationsearch=driver.findElement(Locationsearchtext);
		elementutil.doSendKeys(Locationsearchtext, locationid);
		elementutil.waitForElementWithFluentWait(Locationresult, 10, 2);
//		locationsearch.sendKeys("99999");
		
//		driver.findElement(Locationresult).click();
		elementutil.doClick(Locationresult);
	}
	
	public void clickOnLoginButton() {
		elementutil.doClick(Loginbutton);
	}
	
	public void clickOnMyAccountLink() {
		WebElement myaccountdropdown=driver.findElement(myaccountlink);
		elementutil.selectDropdown(myaccountdropdown, "Profile");
	}
	
}
