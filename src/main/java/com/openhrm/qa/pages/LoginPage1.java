package com.openhrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openhrm.qa.base.TestBase;

public class LoginPage1 extends TestBase {
	
	

	@FindBy(xpath = "//div[@id='divLogo']//img")
	WebElement lp_logo;

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement password;

	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement lgn_btn;
	
	public LoginPage1() {
		PageFactory.initElements(driver, this);
	}

	public String loginpage_title() {
		return driver.getTitle();
	}

	public boolean loginpage_logo() {

		// driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();

		return lp_logo.isDisplayed();

	}

	public HomePage login(String u_name, String psswrd) {
/*
		driver.findElement(By.id("txtUsername")).sendKeys(u_name);
		driver.findElement(By.id("txtPassword")).sendKeys(psswrd);
		driver.findElement(By.id("btnLogin")).click();*/
		
		username.sendKeys(u_name);
		password.sendKeys(psswrd);
		lgn_btn.click();

		return new HomePage();

	}

}
