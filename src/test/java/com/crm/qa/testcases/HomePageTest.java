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

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	public HomePageTest() throws IOException {
		super();
		
	}
	//testcases should be independent.(so that browser does not get exhausted,no cookies /cache issue is found)
	//before each test case--launch browser and login
	//after each test case-close the browser
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage();// to access login page class method we have to create loginpage object
		homePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage= new ContactsPage();
		
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title=homePage.verifyHomePageTitle();
	Assert.assertEquals(title,"Cogmento CRM");
	     }
	
	@Test
	public void verifyUserNameTest() {
	Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test
	public void verifyContactsLinkTest() throws IOException {
		 contactsPage=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
