package com.massmutual.stepdefinitions;

import com.massmutual.pageobjects.BalanceCheckPageObjects;
import com.massmutual.testbase.TestBase;

import io.cucumber.java.en.Then;

public class BalanceCheckPageSteps extends TestBase {
	public BalanceCheckPageObjects balanceCheckPageObjects;
	
	
	@Then("I verify the right count of values appear on the screen")
	public void i_verify_the_right_count_of_values_appear_on_the_screen() {
		balanceCheckPageObjects = new BalanceCheckPageObjects(driver);
		balanceCheckPageObjects.valuesAppearOntheScreen();
	}


	@Then("I verify the values on the screen are greater than {int}")
	public void i_verify_the_values_on_the_screen_are_greater_than(Integer int1) {
		balanceCheckPageObjects = new BalanceCheckPageObjects(driver);
		balanceCheckPageObjects.valuesGraterThanZero();

	}

	@Then("I verify the total balance is correct based on the values listed on the screen")
	public void i_verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() {
		balanceCheckPageObjects = new BalanceCheckPageObjects(driver);
		balanceCheckPageObjects.compareTotalBalanceWithSumOfAllValues();
	}


	@Then("I verify the values are formatted as currencies")
	public void i_verify_the_values_are_formatted_as_currencies() {
		balanceCheckPageObjects = new BalanceCheckPageObjects(driver);
		balanceCheckPageObjects.currencyFormatOfValues();
	}

	@Then("I verify the total balance matches the sum of the values")
	public void i_verify_the_total_balance_matches_the_sum_of_the_values() {


	}
}
