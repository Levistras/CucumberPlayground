package com.kavinschool.examples.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kavinschool.examples.hooks.DriverFactory;
import com.kavinschool.examples.utils.DriverUtils;
import com.kavinschool.examples.utils.LocatorUtils;
import com.kavinschool.examples.utils.WaitUtils;

import io.cucumber.java.en.Then;

public class TicketStepDefs {
	private WebDriver driver;
	private DriverUtils driverUtils;
	private LocatorUtils locatorUtils;
	private WaitUtils waitUtils;

	public TicketStepDefs(DriverFactory driverFactory) {
		this.driver = driverFactory.getDriver();
		this.driverUtils = driverFactory.getDriverUtils();
		this.locatorUtils = new LocatorUtils(driver);
		this.waitUtils = new WaitUtils(driver);
	}
	
	@Then("I verify the header text contains {string}")
	public void i_verify_the_header_text_contains(String textMsg) {
		WebElement header =locatorUtils.waitForHeaderWithText(textMsg, "h1");
		Assert.assertEquals(header.getText(),textMsg);
	}

	@Then("I verify the paragraph contains {string}")
	public void i_verify_the_paragraph_contains(String text) {
		WebElement para =locatorUtils.waitForParagraphContainsText(text);
		Assert.assertEquals(para.getText(),text);

	}
	
}
