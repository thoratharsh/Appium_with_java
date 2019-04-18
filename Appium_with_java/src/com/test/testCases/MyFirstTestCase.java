package com.test.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.commonFunctions.CommonFunctions;
import com.test.pageObjects.CalculatorPage;
import com.test.utilities.Browser;
import com.test.utilities.Calculator;

import io.appium.java_client.AppiumDriver;

public class MyFirstTestCase {
	private static final int String = 0;
	AppiumDriver driver = null;
	CommonFunctions action = new CommonFunctions();

	@BeforeTest
	public void setup() {
		driver = action.getDriver("Android", Calculator.appPackage, Calculator.appActivity_CalculatoryActivity,
				Calculator.apkPath);
	}

	@Test(groups = { "test1" })
	
	public void test1() throws InterruptedException {

		String exp = "5222+111+222=5555";

		String equation = exp.split("=")[0];
		String result = exp.split("=")[1];

		for (char ch : equation.toCharArray()) {
			switch (ch) {
			case '1':
				action.click(driver, CalculatorPage.button1);
				break;
			case '2':
				action.click(driver, CalculatorPage.button2);
				break;
			case '3':
				action.click(driver, CalculatorPage.button3);
				break;
			case '4':
				action.click(driver, CalculatorPage.button4);
				break;
			case '5':
				action.click(driver, CalculatorPage.button5);
				break;
			case '6':
				action.click(driver, CalculatorPage.button6);
				break;
			case '7':
				action.click(driver, CalculatorPage.button7);
				break;
			case '8':
				action.click(driver, CalculatorPage.button8);
				break;
			case '9':
				action.click(driver, CalculatorPage.button9);
				break;
			case '0':
				action.click(driver, CalculatorPage.button0);
				break;
			case '+':
				action.click(driver, CalculatorPage.buttonPlus);
				break;
			case '-':
				action.click(driver, CalculatorPage.buttonSubstract);
				break;
			case '*':
				action.click(driver, CalculatorPage.buttonMul);
				break;
			case '=':
				action.click(driver, CalculatorPage.buttonResult);
				break;
			}
			Thread.sleep(200);
		}

		action.click(driver, CalculatorPage.buttonResult);
		Thread.sleep(5000);
		String cal=action.get_text(driver, CalculatorPage.calculatedResult);
		System.out.println("result is:"+cal);
		assertEquals(cal, result,"Results is not correct");
		
	}

	@AfterTest
	public void tearDown() {
		driver.closeApp();
	}

}
