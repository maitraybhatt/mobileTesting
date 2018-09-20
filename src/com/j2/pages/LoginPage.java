package com.j2.pages;

import org.apache.log4j.Logger;

import com.j2.driver.AbstractScreen;
import com.j2.driver.TestBase;
import com.j2.utils.PropertyManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends AbstractScreen {
	final static Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage() {
		super(TestBase.getDriver());

	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Login / Phone Number']")
	private MobileElement username;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']//android.widget.EditText[@index='0']")
	private MobileElement password;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Returning user? Login']")
	private MobileElement Loginbutton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='QA Server']")
	private MobileElement QA_serverbutton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Dev Config']")
	private MobileElement DEVconfigurationbtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Use This URL']")
	private MobileElement URLbutton;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']//android.widget.EditText[@index='1']")
	private MobileElement URLtext;

	@AndroidFindBy(xpath = "//android.widget.ToggleButton[@index='1']")
	private MobileElement rememberPasswordBtn;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.LinearLayout[@index='1']//android.widget.ImageButton")
	private MobileElement help_icon_button;

	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKbutton;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='0']")
	private MobileElement help_msg0;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='1']")
	private MobileElement help_msg1;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='2']")
	private MobileElement help_msg2;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='3']")
	private MobileElement help_msg3;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='4']")
	private MobileElement help_msg4;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Yes']")
	private MobileElement Yes_button;

	/*@AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid credentials. Please correct and try again. If problem persists, please contact Davinci� customer support at (877) 693-2846.']")
	private MobileElement invalidcredential_error;*/

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
	private MobileElement unabletodial_txt;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Close']")
	private MobileElement close_button;

	public MobileElement getUnabletodial_txt() {
		return unabletodial_txt;
	}

	public MobileElement getClose_button() {
		return close_button;
	}

	public MobileElement getHelp_icon_button() {
		return help_icon_button;
	}

	/*public MobileElement getInvalidcredential_error() {
		return invalidcredential_error;
	}*/

	public MobileElement getYes_button() {
		return Yes_button;
	}

	public MobileElement getHelp_msg0() {
		return help_msg0;
	}

	public MobileElement getHelp_msg1() {
		return help_msg1;
	}

	public MobileElement getHelp_msg2() {
		return help_msg2;
	}

	public MobileElement getHelp_msg3() {
		return help_msg3;
	}

	public MobileElement getHelp_msg4() {
		return help_msg4;
	}

	public MobileElement getOKbutton() {
		return OKbutton;
	}

	public MobileElement getQA_serverbutton() {
		return QA_serverbutton;
	}

	public MobileElement getDEVconfigurationbtn() {
		return DEVconfigurationbtn;
	}

	public MobileElement getHelpiconbutton() {
		return help_icon_button;
	}

	public MobileElement getUsername() {
		return username;
	}

	public MobileElement getPassword() {
		return password;
	}

	public MobileElement getLoginbutton() {
		return Loginbutton;
	}

	public MobileElement getQAbutton() {
		return QA_serverbutton;
	}

	public MobileElement getDEVconfiguration() {
		return DEVconfigurationbtn;
	}

	public MobileElement getURLbutton() {
		return URLbutton;
	}

	public MobileElement getURLtext() {
		return URLtext;
	}

	public MobileElement getRememberPasswordBtn() {
		return rememberPasswordBtn;
	}

	/**
	 * Method to Login into application
	 */
	public void doLogin() {
		TestBase.waitForPresent(getUsername());
		getUsername().clear();
		getUsername().sendKeys(PropertyManager.getResourceBundle().getString("username"));
		TestBase.getDriver().hideKeyboard();
		getPassword().clear();
		getPassword().sendKeys(PropertyManager.getResourceBundle().getString("password"));
		TestBase.getDriver().hideKeyboard();
		getLoginbutton().click();
		TestBase.waitForPresent(getYes_button());
		getYes_button().click();
		getOKbutton().click();
	}

	/**
	 * Method to do login with invalid DID credential
	 */
	public void dologin_with_invalid_DID() {
		getUsername().clear();
		getUsername().sendKeys(PropertyManager.getResourceBundle().getString("invalidusername"));
		TestBase.getDriver().hideKeyboard();
		getPassword().clear();
		getPassword().sendKeys(PropertyManager.getResourceBundle().getString("password"));
		TestBase.getDriver().hideKeyboard();
		getLoginbutton().click();
	}

	/**
	 * Method to do login with invalid password
	 */
	public void dologin_with_invalid_password() {
		TestBase.waitForPresent(getUsername());
		getUsername().clear();
		getUsername().sendKeys(PropertyManager.getResourceBundle().getString("username"));
		TestBase.getDriver().hideKeyboard();
		getPassword().clear();
		getPassword().sendKeys(PropertyManager.getResourceBundle().getString("invalidpassword"));
		TestBase.getDriver().hideKeyboard();
		getLoginbutton().click();
	}

	/**
	 * Method to verify login error
	 */
	/*public void loginError() {
		TestBase.waitForPresent(getInvalidcredential_error());
		
		Basefunctions.verifyTrue(getInvalidcredential_error().getText().contains("Invalid credentials"),
				"User is getting login error message for invalid credential",
				"User is not getting login error message for invalid credential");
		getClose_button().click();
		TestBase.pause(2000);
	}*/

	/**
	 * Method to configure
	 */
	public void doConfig() {
		TestBase.pause(5000);
		//TestBase.getDriver().swipe(60, 1000, 60, 500, 1000);
		getDEVconfiguration().click();
		getQAbutton().click();
		getURLbutton().click();
		TestBase.getDriver().navigate().back();

	}

	/**
	 * Method to click help button and verify the message
	 */
	public void verify_help_Message() throws InterruptedException {
		getOKbutton().click();
	}

	/**
	 * Method to click on yes button
	 */
	public void click_yes_button() {
		getYes_button().click();

	}

	/**
	 * Method to click on help icon
	 */
	public void click_helpIcon() {
		getHelpiconbutton().click();
	}

	/**
	 * Method to Verify the user is shown notification informing them they are
	 * unable to dial 911 from the mobile app
	 */
	public void verify_unabletodial_msg() {
		TestBase.waitForPresent(getUsername());
		getUsername().clear();
		getUsername().sendKeys(PropertyManager.getResourceBundle().getString("username"));
		TestBase.getDriver().hideKeyboard();
		getPassword().clear();
		getPassword().sendKeys(PropertyManager.getResourceBundle().getString("password"));
		TestBase.getDriver().hideKeyboard();
		getLoginbutton().click();
		TestBase.waitForPresent(getYes_button());
		getYes_button().click();
		TestBase.waitForPresent(getUnabletodial_txt());

	}

}