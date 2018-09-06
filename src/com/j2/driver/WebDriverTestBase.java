package com.j2.driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;

public abstract class WebDriverTestBase {

	public WebDriver driver;
	static WebDriverWait wait;
	

	@BeforeTest
	public void DriversetUp() throws Exception {
		  
	       
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        //capabilities.setCapability("device","Android");

	        //mandatory capabilities
	        //capabilities.setCapability("deviceName","emulator-5556");
	        //capabilities.setCapability("platformName","Android");

	        //other caps
	       
	        //capabilities.setCapability("platformVersion","7.0");
	        //capabilities.setCapability("newCommandTimeout","90");
	        //capabilities.setCapability("browserName","android");
	        //capabilities.setCapability("app","resources//davinci-android-4.11.0.1-SNAPSHOT.apk");
	        		
	       
	        driver =  new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	        TestBase.pause(60000);
	        // TODO add the logic to handle different environments here
	}

	@AfterTest
	public void teardownTest() {
		driver.quit();
	}
}
