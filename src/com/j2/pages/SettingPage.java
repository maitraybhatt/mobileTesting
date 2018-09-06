package com.j2.pages;

import org.testng.Reporter;

import com.j2.driver.AbstractScreen;
import com.j2.driver.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingPage extends AbstractScreen {

	public SettingPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	private MobileElement settings;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Outbound Caller ID']")
	private MobileElement outbound_caller_id;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Inbound Caller ID']")
	private MobileElement Inbound_Caller_ID_txt;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Screen']")
	private MobileElement HomeScreen_txt;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Zone']")
	private MobileElement TimeZone_txt;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Override']")
	private MobileElement Override_txt;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@index='2']//android.widget.TextView[@index='0']")
	private MobileElement outbound_caller_id_btn;

	@AndroidFindBy(xpath = "//android.widget.ListView//android.widget.CheckedTextView[@index='0']")
	private MobileElement outbound_caller_id_number;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@index='5']//android.widget.TextView[@index='0']")
	private MobileElement inbound_caller_id_btn;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Davinci Number']")
	private MobileElement inbound_Davinci_number;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Caller�s Number']")
	private MobileElement inbound_callers_number;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@index='8']//android.widget.TextView[@index='0']")
	private MobileElement homescreen_btn;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Keypad']")
	private MobileElement keypad_option;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Call Logs'")
	private MobileElement CalLogs_option;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Messages'")
	private MobileElement Messages_option;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Contacts'")
	private MobileElement Contacts_option;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings'")
	private MobileElement Settings_option;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(.,'Update your')")
	private MobileElement Overide_message;

	@AndroidFindBy(xpath = "//android.widget.ToggleButton[@text='OFF']")
	private MobileElement Overide_toggleBtn;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@index='15']")
	private MobileElement Overide_dropdown;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Voicemail']")
	private MobileElement voicemail_option;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Another Number']")
	private MobileElement AnotherNumber_option;

	public MobileElement getOveride_dropdown() {
		return Overide_dropdown;
	}

	public MobileElement getVoicemail_option() {
		return voicemail_option;
	}

	public MobileElement getAnotherNumber_option() {
		return AnotherNumber_option;
	}

	public MobileElement getOveride_message() {
		return Overide_message;
	}

	public MobileElement getOveride_toggleBtn() {
		return Overide_toggleBtn;
	}

	public MobileElement getHomescreen_btn() {
		return homescreen_btn;
	}

	public MobileElement getInbound_callers_number() {
		return inbound_callers_number;
	}

	public MobileElement getKeypad_option() {
		return keypad_option;
	}

	public MobileElement getCalLogs_option() {
		return CalLogs_option;
	}

	public MobileElement getMessages_option() {
		return Messages_option;
	}

	public MobileElement getContacts_option() {
		return Contacts_option;
	}

	public MobileElement getSettings_option() {
		return Settings_option;
	}

	public MobileElement getInbound_caller_id_btn() {
		return inbound_caller_id_btn;
	}

	public MobileElement getInbound_Davinci_number() {
		return inbound_Davinci_number;
	}

	public MobileElement getOutnbound_Caller_number() {
		return outbound_caller_id_number;
	}

	public MobileElement getSettings() {
		return settings;
	}

	public MobileElement getOutbound_caller_id() {
		return outbound_caller_id;
	}

	public MobileElement getInbound_Caller_ID_txt() {
		return Inbound_Caller_ID_txt;
	}

	public MobileElement getHomeScreen_txt() {
		return HomeScreen_txt;
	}

	public MobileElement getTimeZone_txt() {
		return TimeZone_txt;
	}

	public MobileElement getOverride_txt() {
		return Override_txt;
	}

	public MobileElement getOutbound_caller_id_btn() {
		return outbound_caller_id_btn;
	}

	public MobileElement getOutbound_caller_id_number() {
		return outbound_caller_id_number;
	}

	public void verify_settingscreen_options() {
		Reporter.log("Outbound Caller ID", getOutbound_caller_id().getText().contains("Outbound"));
		Reporter.log("Inbound Caller ID", getOutbound_caller_id().getText().contains("Inbound"));
		Reporter.log("Home Screen", getOutbound_caller_id().getText().contains("Home Screen"));
		Reporter.log("Time Zone", getOutbound_caller_id().getText().contains("Time Zone"));
		Reporter.log("Override", getOutbound_caller_id().getText().contains("Override"));
	}

	/**
	 * Method to verify the user's DavinciÂ® numbers are all listed in the
	 * dropdown.
	 */
	public void verify_outbound_caller_id() {
		getOutbound_caller_id_btn().click();
		Reporter.log("user's DavinciÂ® numbers are  listed in the dropdown",
				getOutbound_caller_id_number().getText().contains("8445551056"));
		getOutbound_caller_id_number().click();
	}

	/**
	 * Method to Verify the options are listed in the Inbound callerId dropdown:
	 */
	public void verify_inbound_caller_id() throws InterruptedException {
		getInbound_caller_id_btn().click();
		Reporter.log("Davinci number option is listed in the dropdown",
				getInbound_Davinci_number().getText().contains("Davinci Number"));
		Reporter.log("Caller's number option is listed in the dropdown",
				getInbound_Davinci_number().getText().contains("Caller�s Number"));
		getInbound_callers_number().click();
		TestBase.pause(5000);
	}

	/**
	 * Method to verify option in the Home screen
	 */
	public void verify_homescreen_options() throws InterruptedException {
		getHomescreen_btn().click();
		Reporter.log("Keypad option is displayed", getKeypad_option().getText().contains("Keypad"));
		Reporter.log("Callogs option is displayed", getKeypad_option().getText().contains("Call Logs"));
		Reporter.log("Message option is displayed", getKeypad_option().getText().contains("Messages"));
		Reporter.log("Contacts option is displayed", getKeypad_option().getText().contains("Contacts"));
		Reporter.log("Settings option is displayed", getKeypad_option().getText().contains("Settings"));
		getKeypad_option().click();
		TestBase.pause(5000);
	}

	/**
	 * Method to verify the text description under Override
	 */
	public void verify_overide_msg() throws InterruptedException {
		Reporter.log("Text description under Override is displayed",
				getOveride_message().getText().contains("Update your call"));
		Reporter.log("Default setting is OFF and no dropdowns are shown",
				getOveride_toggleBtn().getText().contains("OFF"));
		getOveride_toggleBtn().click();
		TestBase.pause(2000);
	}

	/**
	 * Method verify options in the Override drop-down
	 */
	public void verify_overide_options() {
		getOveride_dropdown().click();
		Reporter.log("Voicemail option is displayed", getVoicemail_option().getText().contains("Voicemail"));
		Reporter.log("Another Number option is displayed",
				getAnotherNumber_option().getText().contains("Another Number"));
	}
}
