package com.qa.parking.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;


public class ElementUtil {
private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			System.out.println("locator is: "+locator);
			element = driver.findElement(locator);
			System.out.println("WebElement is created successfully: "+locator);
		} catch (Exception e) {
			System.out.println("some exception get occured with this locator: "+locator);
		}
		return element;
	}
	
	public void selectDropdown(WebElement statedropdown, String dropdowntext) {
		Select select=new Select(statedropdown);
		select.selectByVisibleText(dropdowntext);
	}
	
//	public void moveToElement(WebElement element) {
//		Actions action=new Actions(driver);
//		action.moveToElement(element).build().perform();
//	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doScrollSideBarUp(By locator) {
		getElement(locator).sendKeys(Keys.PAGE_UP);
	}

	public void doScrollSideBarDown(By locator) {
		getElement(locator).sendKeys(Keys.PAGE_DOWN);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void clearValue(By locator) {
		getElement(locator).clear();
	}

	public String doGetURL() {
		return driver.getCurrentUrl();
	}

	public void doSwitchToAlert() {
		driver.switchTo().alert();
	}
	
	public boolean verifyAlertIsPresent(WebDriver driver) {
		
	        try {
	            driver.switchTo().alert();
	            return true;
	        } catch (NoAlertPresentException ex) {
	            return false;
	        }
	}
	
	public void verifyElementIsPresent(By locator) {
		try {
		    WebElement element = driver.findElement(locator);
		    element.click();
		} catch (NoSuchElementException e) {
		    System.out.println("Element not found.");
		    // Handle the case where the element is not found
		} catch (NullPointerException e) {
		    System.out.println("Caught NullPointerException.");
		    // Handle NullPointerException separately if needed
		}
	}

	public void doAcceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void doDismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String doGetTextOnAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void doNavigateBack() {
		driver.navigate().back();
	}

	public void doSwitchToWindow() {
		String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
	}
	
	/************************************ Wait Utils *********************************/
	public static Alert waitForAlert(WebDriver driver, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert();
        } catch (Exception e) {
            return null; // Return null if no alert is present within the timeout
        }
    }
	
	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	public void waitForElementToBeVisible(By locator, int timeout) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public boolean waitForUrl(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(url));
	}

	//	public void waitForLoad(WebDriver driver) {
	//	ExpectedCondition<Boolean> pageLoadCondition = new
	//			ExpectedCondition<Boolean>() {
	//		public Boolean apply(WebDriver driver) {
	//			return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	//		}
	//	};
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
	//	wait.until(pageLoadCondition);
	//}

	public void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(pageLoadCondition);
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeOut))
		.pollingEvery(Duration.ofSeconds(pollingTime))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class);
		
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
