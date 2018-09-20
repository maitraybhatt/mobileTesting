package com.j2.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.j2.driver.AbstractScreen;
import com.j2.driver.TestBase;
import com.j2.utils.Basefunctions;
import com.j2.utils.Property;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TablePage extends AbstractScreen {

	public TablePage() {
		super(TestBase.getDriver());
		
		// TODO Auto-generated constructor stub
	}
	
	Property property= new Property();

	WebDriverWait wait;



	
	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.support.v7.widget.RecyclerView//android.widget.TextView")
	private MobileElement tableDataPresent;	
	
	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.support.v7.widget.RecyclerView")
	private MobileElement tableRows;	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Product']")
	private MobileElement tableHeader1;	
	
	
	 
	 public MobileElement getTableDataPresent() {
			return tableDataPresent;
		}
	 
	 
	 
	 public MobileElement getTableRows() {
			return tableRows;
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
	
	public void verifyRowCount() {
		List<WebElement> elements = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[2]//android.support.v7.widget.RecyclerView"));
		int rowCount = elements.size();
		System.out.println("****row count ="+ rowCount);
		Basefunctions.verifyTrue(rowCount==1, "Verified only 1 row present", "Row count not as expected");
	}

	public void clickProduct() {
		tableDataPresent.click();
	}
	
	public void verifyAscendingOrder() {
		String cellValue="";
		boolean stringComparison = false;
		List<WebElement> elements = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[2]//android.support.v7.widget.RecyclerView"));
		int rowCount = elements.size();
		System.out.println("****row count ="+ rowCount);
		
		tableHeader1.click();
		TestBase.pause(3000);
		String[] cellValues = new String[100];
	
		for(int i=1; i<rowCount; i++)
		{
		WebElement element = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[2]/android.support.v7.widget.RecyclerView["+i+"]//android.widget.TextView"));
		
		cellValue = element.getText();
		System.out.println("****cell value is***"+ i+ cellValue);
		
		cellValues[i] = cellValue;
		}
		
		for(int j=1; j<rowCount-1; j++)
		{
			if(cellValues[j].compareTo(cellValues[j+1])<=0)
				stringComparison=true;
			else {
				stringComparison = false;
				break;
			}
			
		}
		
		Basefunctions.verifyTrue(stringComparison, "Verified ascending order", "Not in ascending order");
	}
	
}
