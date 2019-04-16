package com.test.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.commonFunctions.CommonFunctions;
import com.test.utilities.Calculator;

import io.appium.java_client.AppiumDriver;

public class MyFirstTestCase {
	AppiumDriver driver = null;
	CommonFunctions action = new CommonFunctions();

	@BeforeTest
	public void setup() {
		driver = action.getDriver("Android",Calculator.appPackage,Calculator.appActivity_CalculatoryActivity,Calculator.apkPath);
	}

	@Test(groups = { "test1" })
	public void test1() throws InterruptedException  {
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.closeApp();
	}

}
