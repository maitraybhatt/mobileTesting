package com.j2.driver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.j2.pages.WelcomePage;
import com.j2.utils.PropertyManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase extends WebDriverTestBase {

	public static AppiumDriver<WebElement> driver;

	public static AppiumDriver<WebElement> getDriver() {
		if (driver != null) {
			return driver;
		} else {
			driver = launch();
			return driver;
		}
	}

	public static AppiumDriver<WebElement> launch() {
		try {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File app = new File(classpathRoot, PropertyManager.getResourceBundle().getString("androiddriver.app"));

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserName",
					PropertyManager.getResourceBundle().getString("androiddriver.browserName"));
			capabilities.setCapability("platformName",
					PropertyManager.getResourceBundle().getString("androiddriver.platformName"));
			capabilities.setCapability("deviceName",
					PropertyManager.getResourceBundle().getString("androiddriver.deviceName"));
			capabilities.setCapability("platformVersion",
					PropertyManager.getResourceBundle().getString("androiddriver.platformVersion"));
			capabilities.setCapability("newCommandTimeout",
					PropertyManager.getResourceBundle().getString("androiddriver.newCommandTimeout"));


			capabilities.setCapability("appActivity", "io.farmatrust.mfg.SplashActivity");
			capabilities.setCapability("appPackage", "io.farmatrust.mfg.qa");

			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			//capabilities.setCapability("app", app.getAbsolutePath());
			//capabilities.setCapability("app", "D:\\MobileAutomation\\Pharmacy\\Pharma\\Apk\\mfg_qa_1_1_12.apk");
			capabilities.setCapability("app", "D:\\BlockChain\\mfg_qa_1_1_12.apk");

			System.out.println(
					"======test========" + "http://" + PropertyManager.getResourceBundle().getString("server.ip") + ":"
							+ PropertyManager.getResourceBundle().getString("server.port") + "/wd/hub");

			//driver = new AppiumDriver<WebElement>(new URL("http://" + PropertyManager.getResourceBundle().getString("server.ip")
			//		+ ":" + PropertyManager.getResourceBundle().getString("server.port") + "/wd/hub"), capabilities);
			driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			//driver = new AppiumDriver<WebElement>( new URL("http://202.131.112.106:4723/wd/hub"), capabilities);
			System.out.println("*********connection tested*****" + driver);
			return driver;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void teardownTest() {
		try {
			getscreenshot();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.quit();
		// openTestExecutionReport();
	}

	public void pause(long timeoutInMiliSeconds) {
		try {
			Thread.sleep(timeoutInMiliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPageLoad(long timeOutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
	}

	public void waitForElementVisible(long timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementDisappear(long timeOutInSeconds, WebElement element) {

	}

	public static boolean verifyTrue(Boolean condition, String successMessage, String failureMessage) {
		if (condition) {
			Reporter.log(successMessage, true);
			return true;
		} else {
			Reporter.log(failureMessage, false);
			return false;
		}
	}

	public static boolean verifyFalse(Boolean condition, String successMessage, String failureMessage) {
		if (!condition) {
			Reporter.log(successMessage, true);
			return true;
		} else {
			Reporter.log(failureMessage, false);
			return false;
		}
	}

	public void getscreenshot() throws Throwable {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotName = new File(PropertyManager.getResourceBundle().getString("SCREENSHOT_LOCATION")
				+ System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(scrFile, screenshotName);
			Reporter.log("Taking screenshot");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}

	public static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void waitForPresent(MobileElement Element) {
		long timout = Integer.parseInt(PropertyManager.getResourceBundle().getString("timeOutInSeconds"));

		WebDriverWait wait = new WebDriverWait(getDriver(), timout);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	/*
	 * public static void allowAppPermission() throws InterruptedException{
	 * 
	 * Thread.sleep(3000);
	 * 
	 * while
	 * (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")
	 * ).size()>0)
	 * 
	 * {
	 * driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).
	 * click(); } }
	 */

}
