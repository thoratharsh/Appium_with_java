package com.test.commonFunctions;

import static org.testng.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.utilities.Config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;

public class CommonFunctions {
	AppiumDriver driver = null;

	@Step("Open mobile application : {0} ")
	public AppiumDriver getDriver(String platformName, String appPackage, String appActivity, String apkPath) {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "");
			cap.setCapability("deviceName", "My Android");
			cap.setCapability("platformName", platformName);
			cap.setCapability("VERSION", "");
			cap.setCapability("appPackage", appPackage);
			cap.setCapability("appActivity", appActivity);

			if (platformName.equalsIgnoreCase("Android")) {
				driver = new AndroidDriver(new URL(Config.appiumServerIP), cap);
			} else
				driver = new IOSDriver(new URL(Config.appiumServerIP), cap);

			try {
				if (!driver.isAppInstalled(appPackage)) {
					driver.installApp(apkPath);
				}
			} catch (Exception e) {
				assertTrue(false, "Apk file path not correct and app is not installed");
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	@Step("Click on {1}")
	public void click(AppiumDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	@Step("Enter {2} text in {1}")
	public void enter_text(AppiumDriver driver, String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

}
