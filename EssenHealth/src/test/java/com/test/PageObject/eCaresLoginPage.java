package com.test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eCaresLoginPage {

	WebDriver ldriver;

	public eCaresLoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "UserName")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(name = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement signInButton;

	@FindBy(xpath="//input[@type='submit']//following-sibling::a")
	@CacheLookup
	WebElement clickForgotPwd;
	

	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void ClickSingIn() {
		signInButton.click();
	}

	public void clickForgtPasswd()
	{
		clickForgotPwd.click();
	}


}