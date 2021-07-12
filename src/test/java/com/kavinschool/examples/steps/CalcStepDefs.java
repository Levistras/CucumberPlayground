package com.kavinschool.examples.steps;

import org.junit.Assert;

import com.kavinschool.examples.Calc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalcStepDefs {

	private Calc calc;
	private double result;

	@Given("the numbers {int} and {int}")
	public void the_numbers_and(Integer a, Integer b) {
		calc = new Calc(a, b);
	}

	@When("they are added together")
	public void they_are_added_together() {
		result = calc.add();
	}

	@Then("the expected result should be {int}")
	public void the_expected_result_should_be(double expectedResult) {
		Assert.assertEquals(expectedResult, result, 0.0);
	}
	
	@When("they are subtracted")
	public void they_are_subtracted() {
	    result = calc.sub();
	}
	
	@When("they are divided")
	public void they_are_divided() {
		result = calc.div();
	}

	@When("they are multiplied")
	public void they_are_multiplied() {
		result = calc.mul();
	}


}
