package com.kavinschool.examples.steps;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.kavinschool.examples.hooks.DriverFactory;
import com.kavinschool.examples.utils.DriverUtils;
import com.kavinschool.examples.utils.LocatorUtils;
import com.kavinschool.examples.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoInputsStepDefs {
	private WebDriver driver;
	private DriverUtils driverUtils;
	private LocatorUtils locatorUtils;
	private WaitUtils waitUtils;

	public DemoInputsStepDefs(DriverFactory driverFactory) {
		this.driver = driverFactory.getDriver();
		this.driverUtils = driverFactory.getDriverUtils();
		this.locatorUtils = new LocatorUtils(driver);
		this.waitUtils = new WaitUtils(driver);
	}

	@When("I go to {string}")
	public void i_go_to(String url) {
		driver.get(url);
	}

	@Then("Title should be {string}")
	public void title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("First H2 Element should match with {string}")
	public void first_h2_element_should_match_with(String expectedHeader) {
		// Approach 1
		WebElement header1 = driver.findElement(By.xpath("//h2[normalize-space()='Provide Your Details:']"));
		Assert.assertEquals(expectedHeader, header1.getText());

		// Approach 2
		WebElement header2 = locatorUtils.waitForHeaderWithText(expectedHeader, "h2");
		Assert.assertEquals(expectedHeader, header2.getText());
	}

	@Then("URL should be {string}")
	public void url_should_be(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("I accept popup alert with msg {string}")
	public void i_accept_popup_alert_with_msg(String expectedMessage) {
		String actualMessage = driverUtils.closeAlertAndGetItsText(true);
		Assert.assertEquals(expectedMessage, actualMessage);

	}

	@Then("I verify the Edit button should be present")
	public void i_verify_the_edit_button_should_be_present() {
		// Approach 0
		boolean isDisployed = driver.findElement(By.id("edit")).isDisplayed();
		Assert.assertTrue("Edit button not present", isDisployed);

		// Approach 1
		isDisployed = locatorUtils.isElementPresent(By.id("edit"));
		Assert.assertTrue("Edit button not present", isDisployed);

		// Approach 2
		isDisployed = locatorUtils.isElementDisplayed(By.id("edit"));
		Assert.assertTrue("Edit button not present", isDisployed);

		// Approach 3
		isDisployed = waitUtils.waitForElementPresent(By.id("edit"));
		Assert.assertTrue("Edit button not present", isDisployed);
	}

	@When("I enter firstName {string}")
	public void i_enter_first_name(String name) {
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.clear();
		firstName.sendKeys(name);

	}

	@When("I enter lastName {string}")
	public void i_enter_last_name(String name) {
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.clear();
		lastName.sendKeys(name);
	}

	@When("I enter email {string}")
	public void i_enter_email(String emailId) {
		WebElement email = driver.findElement(By.name("email"));
		email.clear();
		email.sendKeys(emailId);
	}

	@Then("I select training choice from the dropdown")
	public void i_select_training_choice_from_the_dropdown() {
		WebElement training = driver.findElement(By.xpath("//select[@id='course']"));
		Select course = new Select(training);
		// Approach 1
		course.selectByIndex(1);
		waitUtils.kiloHold();
		// Approach 2
		course.selectByValue("angular");
		waitUtils.kiloHold();
		// Approach 3
		course.selectByVisibleText("NodeJS");
	}

	@When("I click radio button with value {string}")
	public void i_click_radio_button(String value) {
		String locator = String.format("//input[@value='%s']", value);
		driver.findElement(By.xpath(locator)).click();
	}

	@When("I click checkbox with value {string}")
	public void i_click_checkbox(String value) {
		String locator = String.format("//input[@value='%s']", value);
		driver.findElement(By.xpath(locator)).click();
	}

}
