package com.j2.test;

import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.j2.driver.TestBase;
import com.j2.pages.FT2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;




public class TestSuite {
	public static AppiumDriver<WebElement> driver;
	WebDriverWait wait;
	
	@Test(priority = 1, description = "TC_1 ")
	public void TC_1() throws InterruptedException {
		String header = "header";
		
		FT2 testCase1 = new FT2();
		testCase1.clickAllowCamera();
		TestBase.pause(5000);
		testCase1.verifyFirstPage();
		TestBase.pause(5000);
		testCase1.clickViewAll();
		TestBase.pause(5000);
		
		for(int i=0;i<4;i++)
		{
			testCase1.verifyTableHeader(header,i );
		}
		testCase1.verifyTableDataPresent();
		
	}

/*	@Test(priority = 2, description = "Davinci Android Tablet - Login - Invalid User Error")
	public void TC_22303() {
		LoginPage loginpage = new LoginPage();

		// Login with invalid DID credential
		loginpage.dologin_with_invalid_DID();
		loginpage.loginError();
		TestBase.getDriver().resetApp();

		// Login with invalid password
		loginpage.dologin_with_invalid_password();

		// Verify Login fails & the following login error is returned
		TestBase.waitForPresent(loginpage.getInvalidcredential_error());
		Basefunctions.verifyTrue(loginpage.getInvalidcredential_error().getText().contains("Invalid credentials"),
				"Following error  should display:Invalid credentials. Please correct and try again. If problem persists, please contact Davinci customer support at (877) 693 2846",
				"Following error  should display:Invalid credentials. Please correct and try again. If problem persists, please contact Davinci customer support at (877) 693 2846");

		// Dismiss pop-up
		loginpage.getClose_button().click();
		TestBase.getDriver().resetApp();
	}

	@Test(priority = 3, description = "Davinci Android Phone - Keypad - Add Number to Contacts")
	public void TC_22325() {
		KeypadPage keypadpage = new KeypadPage();
		TemplatePage templatepage = new TemplatePage();
		LoginPage loginpage = new LoginPage();
		ContactPage contactpage = new ContactPage();

		// Login with valid credentials
		loginpage.doLogin();
		TestBase.waitForPresent(keypadpage.getAddcontact_button());

		// Click on Add contact button
		keypadpage.getAddcontact_button().click();

		// Verify it is displaying add new contact button or not
		Basefunctions.verifyTrue(keypadpage.getAddcontact_txt().getText().contains("Add new contact"),
				"The 'Add New Contact' screen open", "The 'Add New Contact' screen not open");
		TestBase.getDriver().navigate().back();

		// Add 10 digit number
		keypadpage.enter_10_digitnumber();

		// Verify added number on contact details page and add contact
		keypadpage.verify_contactpage();
		templatepage.open_contacts();

		// verify added contact details
		contactpage.verify_contactName();
		TestBase.getDriver().resetApp();

	}

	@Test(priority = 4, description = "Davinci Android Phone - Keypad - Number Format")
	public void TC_22327() {
		KeypadPage keypadpage = new KeypadPage();
		LoginPage loginpage = new LoginPage();

		// Login with valid credentials
		loginpage.doLogin();

		// Verify entering 11 digit number
		keypadpage.enter_11_digitnumber();

		// Enter a domestic/US number; lead with the country code of 1
		Basefunctions.verifyTrue(keypadpage.enter_domestic_USnumber(),
				"Entry is accepted as Per requirements:If 10 digit number is entered with a 1 first display 1(415)-555-1122",
				"Entry is not accepted as Per requirements:If 10 digit number is entered with a 1 first display 1(415)-555-1122");

		// Verify number format when it is not leading with 1
		Basefunctions.verifyTrue(keypadpage.enter_domestic_USnumber_omit1(),
				"Entry is accepted as Per requirements: 'If 10 digit number is entered without 1 first display (415)-555-1122'",
				"Entry is not accepted as Per requirements: 'If 10 digit number is entered without 1 first display (415)-555-1122'");
		TestBase.getDriver().resetApp();

	}

	@Test(priority = 5, description = "Davinci Android Phone - Notification - 911 Prompt")
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
