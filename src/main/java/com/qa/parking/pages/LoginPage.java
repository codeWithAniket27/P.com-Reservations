package com.qa.parking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.parking.base.BaseTest;
import com.qa.parking.utils.ElementUtil;

public class LoginPage extends BaseTest{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	
	By emailaddress=By.xpath("//input[@id='email_field']");
	By password=By.xpath("//input[@id='password_field']");
	By forgotpassword=By.xpath("//a[normalize-space()='Forgot Password?']");
	By loginbutton=By.xpath("//button[normalize-space()='Log In']");
	By loginwithgooglebutton=By.xpath("//span[normalize-space()='Login with Google']");
	By signupbutton=By.xpath("//a[contains(@class,'button button--yellow button--sm')]");
	
	public void doLogin(String email,String pwd) {
		elementutil.doSendKeys(emailaddress, email);
		elementutil.doSendKeys(password, pwd);
		elementutil.doClick(loginbutton);
	}
	
	public void clickOnForgotPasswordLink() {
		elementutil.doClick(forgotpassword);
	}

}
