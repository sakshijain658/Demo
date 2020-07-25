package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	

	//PageFactoey or  Object repository of login page
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	public LoginPage() throws IOException {
		super();
		//initialisng page objects
		PageFactory.initElements(driver, this);// initialise the elements with driver and this(current class object
												//here in this case username,password,signUnBtn)
		}
//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
//	public boolean validateCRMImage() {
//		crmLogo.isDisplayed():
//			
//	}

	public HomePage login(String un ,String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
}
