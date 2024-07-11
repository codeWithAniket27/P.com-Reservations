package com.qa.parking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.parking.base.BaseTest;

public class ProfilePage extends BaseTest{
	private WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By emailaddresstext=By.xpath("//input[@placeholder='user@email.com']");
	By firstnametext=By.xpath("//input[@placeholder='First name']");
	By lastnametext=By.xpath("//input[@placeholder='Last name']");
	By mobilenumbertext=By.xpath("//input[@placeholder='(201) 555-0123']");
	By updatebutton=By.xpath("//button[normalize-space()='Update']");
	By changepwdbutton=By.xpath("//a[@href='/update-password']");
	
	
	

}
