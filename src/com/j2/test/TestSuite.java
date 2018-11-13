package com.j2.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.j2.driver.TestBase;
import com.j2.pages.TablePage;
import com.j2.pages.WelcomePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;




public class TestSuite {
	public static AppiumDriver<WebElement> driver;
	WebDriverWait wait;
	

	@Test(priority = 1, description = "Verify table header")
	public void TrackTrace_Verify_table_header() throws InterruptedException {
		String header = "header";
		
		WelcomePage welcomePage = new WelcomePage();
		TablePage tablePage = new TablePage();
		welcomePage.clickAllowCamera();
		TestBase.pause(5000);
		welcomePage.verifyFirstPage();
		TestBase.pause(5000);
		welcomePage.clickViewAll();
		TestBase.pause(40000);
		
		for(int i=0;i<3;i++)
		{
			tablePage.verifyTableHeader(header,i );
		}
		tablePage.verifyTableDataPresent();
		
	}

@Test(priority = 2, description = "Verify Table and Table Header")
	public void TrackTrace_Verify_Table_and_Table_header() throws InterruptedException {
	String header = "header";
	WelcomePage welcomePage = new WelcomePage();
	TablePage tablePage = new TablePage();
	
	welcomePage.clickAllowCamera();
	TestBase.pause(5000);
	
	welcomePage.clickViewAll();
	TestBase.pause(35000);
	
	for(int i=0;i<4;i++)
	{
		tablePage.verifyTableHeader(header,i );
	}
	tablePage.verifyTableDataPresent();
	TestBase.pause(1000);
	
	tablePage.clickProduct();
	TestBase.pause(5000);
	
	tablePage.verifyRowCount();
	
	}

	@Test(priority = 3, description = "Verify_Sorting_Ascending_Order")
		public void TrackTrace_Verify_Ascending_Order() throws InterruptedException {
		WelcomePage welcomePage = new WelcomePage();
		TablePage tablePage = new TablePage();
		
		welcomePage.clickAllowCamera();
		TestBase.pause(5000);
		
		welcomePage.clickViewAll();
		TestBase.pause(35000);
		
		tablePage.verifyAscendingOrder();
		
	}

	@Test(priority = 4, description = "Verify_Sorting_Descending_Order")
	public void TrackTrace_Verify_Descending_Order() throws InterruptedException {
		WelcomePage welcomePage = new WelcomePage();
		TablePage tablePage = new TablePage();
		
		welcomePage.clickAllowCamera();
		TestBase.pause(5000);
		
		welcomePage.clickViewAll();
		TestBase.pause(35000);
		
		tablePage.verifyDescendingOrder();
		
	}

	/*@Test(priority = 5, description = "Davinci Android Phone - Notification - 911 Prompt")
	public void TC_22314() {
		LoginPage loginpage = new LoginPage();


		// Do login and waiting for notification message.
		loginpage.verify_unabletodial_msg();

		// Verifying notification message is as expected or not
		Basefunctions.verifyTrue(loginpage.getUnabletodial_txt().getText().contains("You understand"),
				"A user should be notified upon first login that they are unable to dial 911 from the mobile app",
				"A user should not be notififed upon first login that they are unable to dial 911 from the mobile app");

		// click on OK button.
		loginpage.getOKbutton().click();
		TestBase.getDriver().closeApp();
	}
	*/
}
