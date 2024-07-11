package com.qa.parking.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.parking.base.BasePage;

public abstract class Listeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Execution Started : "+result.getName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Execution Succeeded : "+result.getName());	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		BasePage.takeScreenshot(result.getName());	
		System.out.println("Test Case Execution Failed : "+result.getName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Execution Skipped : "+result.getName());	
	}	

}
