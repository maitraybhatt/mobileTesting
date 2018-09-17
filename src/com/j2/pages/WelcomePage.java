package com.j2.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.j2.driver.AbstractScreen;

import com.j2.driver.TestBase;
import com.j2.utils.Basefunctions;
import com.j2.utils.Property;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends AbstractScreen {

	public WelcomePage() {
		super(TestBase.getDriver());
		
		// TODO Auto-generated constructor stub
	}
	
	Property property= new Property();

	WebDriverWait wait;


	@AndroidFindBy(id = "io.farmatrust.mfg.qa:id/view_all_button")
	private MobileElement viewAllOption;
	
	@AndroidFindBy(xpath = "//android.widget.TextView")
	private MobileElement trackAndTracePage;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout//android.widget.Button[@text='Allow']")
	private MobileElement allowCamera;	
	
	

	public MobileElement getTrackAndTracePage() {
		return trackAndTracePage;
	}

	 public MobileElement getViewAllOption() {
		return viewAllOption;
	}

	 
	 public MobileElement getAllowCamera() {
			return allowCamera;
		}


	public void verifyFirstPage() {
		getTrackAndTracePage().isDisplayed();
		System.out.println("===========Track & Trace app opened==========");
	}

	public void clickViewAll()  {
		getViewAllOption().click();
		System.out.println("===========Clicked on view all==========");
	}
	
	public void clickAllowCamera() throws InterruptedException {
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//android.widget.LinearLayout//android.widget.Button[@text='Allow']")).click();
		getAllowCamera().click();
		System.out.println("===========allow camera clicked==========");
	}
	
	


}
