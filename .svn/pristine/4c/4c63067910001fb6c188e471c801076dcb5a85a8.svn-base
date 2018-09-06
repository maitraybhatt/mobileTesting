package com.j2.pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.j2.driver.AbstractScreen;
import com.j2.driver.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TemplatePage extends AbstractScreen {
	WebDriverWait wait;

	public TemplatePage() {
		super(TestBase.getDriver());
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Keypad']")
	private MobileElement Keypad_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Call Logs']")
	private MobileElement call_logs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbox']")
	private MobileElement inbox_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contacts']")
	private MobileElement contact_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
	private MobileElement more_button;

	public WebDriverWait getWait() {
		return wait;
	}

	public MobileElement getKeypad_button() {
		return Keypad_button;
	}

	public MobileElement getCall_logs() {
		return call_logs;
	}

	public MobileElement getInbox_button() {
		return inbox_button;
	}

	public MobileElement getContact_button() {
		return contact_button;
	}

	public MobileElement getMore_button() {
		return more_button;
	}

	/**
	 * Method to open Keypad screen
	 */
	public void open_keypad() {
		getKeypad_button().click();
	}

	/**
	 * Method to open call_logs screen
	 */
	public void open_call_logs() {
		getCall_logs().click();
		TestBase.pause(2000);
	}

	/**
	 * Method to open inbox screen
	 */
	public void open_inbox() {
		getInbox_button().click();
		TestBase.pause(2000);
	}

	/**
	 * Method to open contact screen
	 */
	public void open_contacts() {
		TestBase.waitForPresent(getContact_button());
		getContact_button().click();
	}

	/**
	 * Method to open More screen
	 */
	public void open_more() {
		TestBase.waitForPresent(getMore_button());
		getMore_button().click();
	}

}
