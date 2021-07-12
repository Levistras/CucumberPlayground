package com.kavinschool.examples.steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssertStepDefs {
	@Given("User compares two doubles {double} and {double}")
	public void user_compares_two_doubles_and(Double double1, Double double2) {
		Assert.assertEquals(double1, double2, 0.001);
	}

	@When("User compares two numbers {int} and {int}")
	public void user_compares_two_numbers_and(Integer int1, Integer int2) {
		Assert.assertEquals(int1, int2);
	}

	@Then("User compares two string values {string} and {string}")
	public void user_compares_two_string_values_and(String string1, String string2) {
		Assert.assertEquals(string1, string2);
	}

}
