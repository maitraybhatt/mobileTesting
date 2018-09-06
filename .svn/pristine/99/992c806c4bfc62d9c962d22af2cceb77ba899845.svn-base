package com.j2.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


class testCaseFailed extends Exception{
	testCaseFailed(String s){
		super(s);
	}
}
public class Reporter extends org.testng.Reporter {
	 
	static Logger log = Logger.getLogger(Reporter.class.getName());

	public enum MessageType {
		INFO, PASS, FAIL;
	}

	public static void log(String Message, MessageType messageType) {

		log.info(Message);

		if (messageType == MessageType.FAIL) {

			log("<font color='red'>FAIL </font> " + Message + "<br>",true);

		} else if (messageType == MessageType.PASS) {
			log("<font color='green'>PASS </font> " + Message + "<br>",true);
		} else {
			log("<font color='blue'>INFO </font> " + Message + "<br>",true);
		}
	}
	
	
public void getscreenshot() throws Throwable {
		
		File scrFile = ((TakesScreenshot) TestbaseMobile.driver).getScreenshotAs(OutputType.FILE);
		File screenshotName = new File(PropertyManager.getResourceBundle().getString("SCREENSHOT_LOCATION")+ System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(scrFile, screenshotName);
			Reporter.log("Taking screenshot");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
	public static void log(boolean condition, String passMessage, String failMessage) throws testCaseFailed{
		
		if(condition){
			log(passMessage,MessageType.PASS);
			
		}else{
			log(failMessage,MessageType.FAIL);
			throw new testCaseFailed("Test case failed");
		}
	}
	

	/*@SuppressWarnings({ "resource" })
	public static HashMap<String, String> getAllSnapshots(ITestResult arg0) {
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<String> filePathlist = new ArrayList();
			String dirName = getResourceBundle().getString("test.results.screenshots.dir") + "/";
			String className = arg0.getTestClass().getRealClass().getSimpleName();
			String methodName = arg0.getName();
			File folder = new File(dirName);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (StringUtility.startsWithIgnoreCase(listOfFiles[i].getName(), className + "_" + methodName)) {
					filePathlist.add(listOfFiles[i].getAbsolutePath());
				}
			}
			FileInputStream fileInputStream = null;
			HashMap<String, String> imgMap = new HashMap<String, String>();
			for (int i = 0, p = 1; i < filePathlist.size(); i++, p++) {
				fileInputStream = new FileInputStream(new File(filePathlist.get(i).toString()));
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				for (int rdNumber; (rdNumber = fileInputStream.read(buffer)) != -1;) {
					outputStream.write(buffer, 0, rdNumber);
				}
				imgMap.put(className + "_" + methodName + "_" + p + ".png",
						(Base64.encodeBase64(outputStream.toByteArray()).toString()));
			}
			return imgMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/*public static String getDescriptionValue(ITestResult arg0) {
		String descriptionTemp = "";
		List<String> outputMessages = org.testng.Reporter.getOutput(arg0);
		if (!outputMessages.isEmpty()) {
			for (int i = 0; i < outputMessages.size(); i++) {
				descriptionTemp += outputMessages.get(i).replaceAll("<[^>]*>", "").replace("[View ScreenShot]", "")
						+ "\n";
			}
		} else {
			descriptionTemp += "Fail " + arg0.getMethod().getMethodName() + "\n";
		}
		return descriptionTemp;
	}

	public String getDefaultDescription() {
		String descriptionTemp = "";
		String os = "os.name";
		String arch = "os.arch";
		descriptionTemp += "\n==================================================================\n";
		descriptionTemp += "Project Details\n";
		descriptionTemp += "==================================================================\n\n";
		descriptionTemp += "OS          :: " + System.getProperty(os) + "\n";
		descriptionTemp += "System Type :: " + System.getProperty(arch) + "\n";
		//descriptionTemp += "Browser Name:: " + getResourceBundle().getString("browser") + "\n";
		descriptionTemp += "==================================================================\n\n";
		descriptionTemp += "Test Steps ::\n\n";
		return descriptionTemp;
	}*/

	/*private static void log(String Message, MessageType messageType, boolean screenshot) {

		File image = null;

		if (screenshot) {
			File scrFile = TestBase.getDriver().captureScreenShot();

			String FileName = getCurrentTestResult().getName() + StringUtility.generateRandomString(6)
					+ "_screenshot.jpg";

			image = new File(getResourceBundle().getString("test.results.screenshots.dir") + "/" + FileName);
			try {
				FileUtils.copyFile(scrFile, image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (messageType == MessageType.FAIL) {
			log("<font color='red'>FAIL </font> " + Message + "<a href=file://" + image.getAbsolutePath()
					+ ">[View ScreenShot]</a><br>");
		} else if (messageType == MessageType.PASS) {
			log("<font color='green'>PASS </font> " + Message + "<a href=file://" + image.getAbsolutePath()
					+ ">[View ScreenShot]</a><br>");
		} else {
			log("<font color='blue'>INFO </font> " + Message + "<a href=file://" + image.getAbsolutePath()
					+ ">[View ScreenShot]</a><br>");
		}
	}*/

	/*public static void logWithScreenShot(String Message) {
		log(Message, MessageType.INFO, true);
	}*/
}