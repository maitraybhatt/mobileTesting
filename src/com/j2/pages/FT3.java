package com.j2.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.j2.driver.AbstractScreen;
import com.j2.driver.TestBase;
import com.j2.utils.Basefunctions;
import com.j2.utils.Property;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FT3 extends AbstractScreen {

	public FT3() {
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
	
	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.support.v7.widget.RecyclerView//android.widget.TextView")
	private MobileElement tableDataPresent;	
	

	public MobileElement getTrackAndTracePage() {
		return trackAndTracePage;
	}

	 public MobileElement getViewAllOption() {
		return viewAllOption;
	}
	 
	 public MobileElement getTableDataPresent() {
			return tableDataPresent;
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
	
	
	public void verifyTableHeader(String header, int i) {
		
		String elementText = property.getInput(header, i);
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='"+elementText+"']"));
		String test = element.getText();
		System.out.println("*****elements text is****" + test);
		Basefunctions.verifyTrue(element.isDisplayed(),"Verified Header "+(i+1)+" ","Header "+(i+1)+" not verified");
	}
	
	public void verifyTableDataPresent() {
		Basefunctions.verifyTrue(getTableDataPresent().isDisplayed(),"Verified table","Table not verified");
	}
	
}
