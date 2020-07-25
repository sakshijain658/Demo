package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	
	public ContactsPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		// testUtil =new TestUtil();
		loginPage=new LoginPage();
		contactsPage= new ContactsPage();	
		homePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
		
	}
	
	@Test (priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue( contactsPage.verifyContactsLabel(),"contactlabel is missing");
	}
	
	@Test (priority=3)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("test test");
	}
	
	
	
//	@Test (priority=3)
//	public void selectMultipleContactsTest() {
//		contactsPage.selectContactsByName("test test");
//		contactsPage.selectContactsByName("test2 test2");
//		
//	}
	
	@Test(priority=2)
	public void validateCreateNewContact() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("goel", "jande");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
