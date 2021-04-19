package com.massmutual.stepdefinitions;

import com.massmutual.pageobjects.LoginPageObjects;
import com.massmutual.testbase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageSteps extends TestBase {
	public LoginPageObjects loginPage;

	@Given("I launch {string}")
	public void i_launch(String string) {
		System.out.println("Browser launched");
	}

	@Given("I enter {string}")
	public void i_enter(String string) {
		System.out.println("Driver navigate to required URL");
	}

	@Given("I enter {string} and {string}")
	public void i_enter_and(String string, String string2) {
		loginPage = new LoginPageObjects(driver);
		loadData("config");
		enterTextInElement(loginPage.getUserID(), OR.getProperty("UserID"));
		enterTextInElement(loginPage.getPassword(), OR.getProperty("Password"));
		elementIsDisplayed(loginPage.getResetButton());
	}

	@Given("I click on Login button")
	public void i_click_on_login_button() {
		loginPage = new LoginPageObjects(driver);
		clickElement(loginPage.getLoginButton());
	}

	@Then("I verify login is succcess")
	public void i_verify_login_is_succcess() {
		System.out.println("Login success");
	}

	@Then("I close the browser")
	public void i_close_the_browser() {
		System.out.println("Close the browser");
	}

}
