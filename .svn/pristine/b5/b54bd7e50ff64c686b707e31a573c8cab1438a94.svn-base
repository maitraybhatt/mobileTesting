package com.j2.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestbaseMobile {
	
	public static AppiumDriver<WebElement> driver;
	

	public static AppiumDriver<WebElement> getdriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "nexus5");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("newCommandTimeout", "60");
		capabilities.setCapability("app", "C:\\Users\\csvegad\\Downloads\\davici.apk");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
	}
	



}
