package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Sakshi Goel')]")
	@CacheLookup 
	WebElement userNameLabel;// cachelookUP will store this element in cachee
	//memory,everytym we are intracting with element instead of page it will get it from cache .speed of script will improve
	//now,this element will be stored in cache memory
	//but somehow,if page gets refreshed/DOM gets changed then cache memory will got corrupted/may get staled.
	//just put there when we are sure that there wud not be any refresh
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newButtton;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;


	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() throws IOException {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		contactsLink.click();
		newButtton.click();
		
	}
}
