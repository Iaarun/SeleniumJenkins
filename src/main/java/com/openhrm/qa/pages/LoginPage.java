package com.openhrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openhrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Object Repository
 // WebElement user1= driver.findElement(By.id("txtUsername"));
	
    @FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement lgn_btn;

	@FindBy(xpath = "//div[@id='divLogo']/img")
	WebElement logo;

	// initialize OR testmethod
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Functions
	public String validatetitle() {
		return driver.getTitle();
	}
	
	public String validate_title() {
		 return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		lgn_btn.click();
		
		return new HomePage();
	}

}
