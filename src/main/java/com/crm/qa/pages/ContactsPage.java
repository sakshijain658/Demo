package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {


@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
WebElement contactsLabel;

@FindBy(xpath="//button[@class='ui linkedin button']")
WebElement saveBtn;


public ContactsPage() throws IOException {
	PageFactory.initElements(driver, this);
	
}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {	
			driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]"
					+ "//preceding-sibling::td//div//input[@name='id']")).click();
	}
	
	public void createNewContact(String fname,String lname) {
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lname);
		saveBtn.click();
	}
	
	

}
