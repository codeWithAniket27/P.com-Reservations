package com.qa.parking.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.ElementUtil;
import com.qa.parking.utils.ExcelUtil;

public class CheckoutPage extends BaseTest{
	private WebDriver driver;
	public CheckoutPage(WebDriver driver) throws IOException {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
		prop=new Properties();
	}
	
	//Object Repository
	By emailaddresstext=By.xpath("//input[@placeholder='ex- jane.doe@gmail.com']");
	By firstnametext=By.xpath("//input[@placeholder='ex- Jane']");
	By lastnametext=By.xpath("//input[@placeholder='ex- Doe']");
	By mobilenumbertext=By.xpath("//input[@placeholder='(201) 555-0123']");
	By licenseplatetext=By.xpath("//input[@id='licensePlate']");
	By state=By.xpath("//select[@id='licensedState']");
	By creditcardtext=By.xpath("//input[@id='secure-payment-field']");
	By cardexpirationtext=By.xpath("//input[@class='card-expiration']");
	By cardcvvtext=By.xpath("//*[contains(@class, 'card-cvv')]");
	By zipcodetext=By.xpath("//input[@id='postalCode']");
	By completepurchasebutton=By.xpath("//button[@id='completePurchase']");
	By errormessage=By.xpath("//div[@class='modal-body']");
	By ordertotal=By.xpath("//span[@id='txtOrderTotal']");
	By tnccheckbox=By.xpath("//input[@id='terms']");
	By parkingperiod=By.xpath("//h2[@class='billing-details mb-0 mb-xl-1']//span[2]");
	By parkingfee=By.xpath("//span[@id='totalsPirce']");
	
	//ObjectInCaseOfLoggedInUser
	By changepaymentradiobutton=By.xpath("//input[@id='differentPaymentOptionRadio']");
	By editprofilename=By.xpath("//label[@for='edit-profile-name'][normalize-space()='EDIT']");
	By editprofitphone=By.xpath("//label[@for='edit-profile-phone'][normalize-space()='EDIT']");
	By firstnamelabel=By.xpath("//span[@class='fNameLabel']");
	By lastnamelabel=By.xpath("//span[@class='lNameLabel']");
	By emaillabel=By.xpath("//span[@class='emailLabel']");
	
	//Action Methods
	public void enterCheckoutDetails(String emailaddress,String firstname,String lastname,String mobilenumber,String licenseplate,String cardnumber,String cardexpiry,String cvv,String zipcode) {
		elementutil.waitForElementPresent(emailaddresstext, 10);
		System.out.println(elementutil.doGetText(ordertotal));
		elementutil.doSendKeys(emailaddresstext, emailaddress);
		elementutil.doSendKeys(firstnametext, firstname);
		elementutil.doSendKeys(lastnametext, lastname);
		elementutil.doSendKeys(mobilenumbertext, mobilenumber);
		elementutil.doSendKeys(licenseplatetext, licenseplate);
		WebElement dropdown=driver.findElement(this.state);
		elementutil.selectDropdown(dropdown, "New York");
		driver.switchTo().frame("card-number");
		elementutil.doSendKeys(creditcardtext, cardnumber);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("card-expiration");
		elementutil.doSendKeys(cardexpirationtext, cardexpiry);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("card-cvv");
		elementutil.doSendKeys(cardcvvtext, cvv);
		driver.switchTo().defaultContent();
		elementutil.doSendKeys(zipcodetext, zipcode);
//		elementutil.doClick(completepurchasebutton);
//		elementutil.waitForAlert(driver, 20);
//		if(elementutil.verifyAlertIsPresent(driver)) {
//			Alert alert=driver.switchTo().alert();
//			String errormsg=elementutil.doGetText(errormessage);
//			System.out.println(errormsg);
//		}
	}
	
	public void verifyCheckoutDetailsForLoggedInUser() {
		elementutil.waitForElementPresent(firstnamelabel, 20);
		String firstname=elementutil.doGetText(firstnamelabel);
		System.out.println("First name of the user is : "+firstname);
		String lastname=elementutil.doGetText(lastnamelabel);
		System.out.println("Last name of the user is : "+lastname);
		System.out.println("Email address of the user is : "+elementutil.doGetText(emaillabel));
		System.out.println("Order price of the reservation is : "+elementutil.doGetText(ordertotal));
		elementutil.doClick(completepurchasebutton);
	}
	
	public void clickOnTncCheckBox() {
		elementutil.waitForElementPresent(tnccheckbox, 10);
		System.out.println("The parking period for the subscription is : "+elementutil.doGetText(parkingperiod));
		System.out.println("The total parking price for the subscription is : "+elementutil.doGetText(parkingfee));
		elementutil.doClick(tnccheckbox);
		elementutil.doClick(completepurchasebutton);
	}
	
}
