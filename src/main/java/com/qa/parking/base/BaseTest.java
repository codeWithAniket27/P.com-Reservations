package com.qa.parking.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.parking.pages.CheckoutPage;
import com.qa.parking.pages.HomePage;
import com.qa.parking.pages.LocationDetailsPage;
import com.qa.parking.pages.LoginPage;
import com.qa.parking.pages.OrderCompletePage;
import com.qa.parking.pages.SubscriptionsProductPage;
import com.qa.parking.utils.ElementUtil;
import com.qa.parking.utils.ExcelUtil;

public class BaseTest {
	private WebDriver driver;
	public BasePage basepage;
	public Properties prop;
	public HomePage homepage_obj;
	public LocationDetailsPage locationdetailspage_obj;
	public CheckoutPage checkoutpage_obj;
	public ElementUtil elementutil;
	public ExcelUtil excelutil;
	public OrderCompletePage ordercompletepage_obj;
	public LoginPage loginpage_obj;
	public SubscriptionsProductPage subscriptionsproductpage_obj;
	
	
	@BeforeTest
	public void Base() throws IOException {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		homepage_obj= new HomePage(driver);
		locationdetailspage_obj=new LocationDetailsPage(driver);
		checkoutpage_obj=new CheckoutPage(driver);
		elementutil=new ElementUtil(driver);
		excelutil=new ExcelUtil();
		ordercompletepage_obj=new OrderCompletePage(driver);
		loginpage_obj=new LoginPage(driver);
		subscriptionsproductpage_obj=new SubscriptionsProductPage(driver);
	}
	
//	@AfterTest
//	public void Tear() {
//		driver.close();
//	}
}
