package com.j2.utils;

import static com.j2.utils.PropertyManager.getResourceBundle;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class Basefunctions extends org.testng.Reporter implements ISuiteListener {
	//public static WebDriver driver;
	
	
	static Logger logger = Logger.getLogger(Basefunctions.class.getName());
	

	public enum MessageType {
		INFO, PASS, FAIL;
	}

	private static String generateLinkForScreenShot() {
		String workspaceLoc = getResourceBundle().getString("workspaceLocation");

		if (!StringUtility.isNullOrEmpty(workspaceLoc)) {
			return workspaceLoc + "/" + getResourceBundle().getString("test.results.screenshots.dir") + "/"
					+ getScreenshot().getName();
		} else {
			return "file://" + getScreenshot().getAbsolutePath();
		}
	}

	public static void log(String Message, MessageType messageType) {

		if (PropertyManager.getResourceBundle().getString("browser").equalsIgnoreCase("ie")) {

			logger.info(messageType.name() + " " + Message);
		}

		logger.info(messageType.name() + " " + Message);

		if (messageType == MessageType.PASS) {
			if (getResourceBundle().getBoolean("screenshotOnPass")) {
				log("<font color='green'>PASS</font> " + Message + "<a href=" + generateLinkForScreenShot()
						+ ">[View ScreenShot]</a><br>");
			} else {
				log("<font color='green'>PASS</font> " + Message + "<br>");
			}
		} else if (messageType == MessageType.FAIL) {
			if (getResourceBundle().getBoolean("screenshotOnFailure")) {
				log("<font color='red'>FAIL </font> " + Message + "<a href=" + generateLinkForScreenShot()
						+ ">[View ScreenShot]</a><br>");
			} else {
				log("<font color='red'>FAIL </font> " + Message + "<br>");
			}

		} else {
			log("<font color='blue'>INFO </font> " + Message + "<a href=" + generateLinkForScreenShot()
					+ ">[View ScreenShot]</a><br>");
		}
	}

	public static void logWithScreenShot(String Message) {

		logger.info(Message);
		if (!getResourceBundle().getBoolean("screenshotOnPass")) {
			log("<font color='blue'>INFO </font> " + Message);
		} else {
			log("<font color='blue'>INFO </font> " + Message + "<a href=" + generateLinkForScreenShot()
					+ ">[View ScreenShot]</a><br>");
		}

	}

	private static File getScreenshot() {
		File image = null;
		try {
			File scrFile = ((TakesScreenshot) TestbaseMobile.getdriver()).getScreenshotAs(OutputType.FILE);
			// File scrFile = ((Object) driver).captureScreenShot();
			String FileName = getCurrentTestResult().getName()
					+ StringUtility.GenerateRandomString(6, StringUtility.Mode.ALPHA) + "_screenshot.png";
			image = new File(getResourceBundle().getString("test.results.screenshots.dir") + FileName);
			FileUtils.moveFile(scrFile, image);

		} catch (IOException e) {
			e.printStackTrace();
			logger.info("Not able to take screenshot" + e.getMessage() + ". " + getCurrentTestResult().getName());
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.error("Not able to take screenshot for particular testcase" + e.getMessage() + ". ");
			image = new File(getResourceBundle().getString("test.results.screenshots.dir")
					+ StringUtility.GenerateRandomString(6, StringUtility.Mode.ALPHA) + "_screenshot.png");
		}
		return image;
	}

	/*public void onFinish(ISuite arg0) {
		driver.quit();

	}*/

	public void onStart(ISuite arg0) {
	/*	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "nexus5");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("newCommandTimeout", "60");
		capabilities.setCapability("app", "C:\\Users\\csvegad\\Downloads\\davici.apk");
		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}
	
	public static boolean verifyTrue(boolean condition, String SuccessMessage, String FailureMessage) {
		if (condition) {
			Basefunctions.log(SuccessMessage, MessageType.PASS);
			return true;
		} else {
			Basefunctions.log(FailureMessage, MessageType.FAIL);
			return false;
		}
	} 
	
	
	   /*public basefunctions(AppiumDriver driver) {
	        this.driver = driver;
	        
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }*/

	  /*  public MobileElement findElementWithTimeout(By by, int timeOutInSeconds) {
	        return (MobileElement)(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
	    }*/

		@Override
		public void onFinish(ISuite suite) {
			// TODO Auto-generated method stub
			
		}
}
