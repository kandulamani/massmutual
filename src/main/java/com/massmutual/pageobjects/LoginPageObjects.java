package com.massmutual.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.massmutual.testbase.TestBase;



public class LoginPageObjects extends TestBase{

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='uid']")
	WebElement userID;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password;

	@FindBy(xpath = "//*[@name='btnLogin']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@name='btnRes==========']")
	WebElement resetButton;

	public WebElement getUserID() {
		return userID;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}
}
