package com.kavinschool.examples.steps;

import static org.junit.Assert.assertEquals;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kavinschool.examples.hooks.DriverFactory;
import com.kavinschool.examples.utils.LocatorUtils;
import com.kavinschool.examples.utils.WaitUtils;

import io.cucumber.java.en.When;

public class FramesStepDefs {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private WebDriver driver;
	private LocatorUtils locatorUtils;
	private WaitUtils waitUtils;

	public FramesStepDefs(DriverFactory driverFactory) {
		this.driver = driverFactory.getDriver();
		this.locatorUtils = new LocatorUtils(driver);
		this.waitUtils = new WaitUtils(driver);
	}

	@When("I switch to frame index {int}")
	public void i_switch_to_frame_index(Integer frameIndex) {
		waitUtils.nanoHold();
		driver.switchTo().defaultContent();
		//driver.switchTo().parentFrame();
		driver.switchTo().frame(frameIndex.intValue());
		log.info("Title:{}", driver.getTitle());
	}

	@When("I switch to frame id {string}")
	public void i_switch_to_frame_id(String frameId) {
		waitUtils.nanoHold();
		driver.switchTo().defaultContent();
		//driver.switchTo().parentFrame();
		driver.switchTo().frame(frameId);
		log.info("Title:{}", driver.getTitle());
	}

	@When("I switch to frame name {string}")
	public void i_switch_to_frame(String frameId) {
		waitUtils.nanoHold();
		driver.switchTo().frame(frameId);
		log.info("Title:{}", driver.getTitle());
	}

	@When("click on {string} link")
	public void click_on_link(String link) {
		locatorUtils.waitForLinkWithText(link).click();
	}

	@When("I click back button")
	public void i_click_back_button() {
		driver.navigate().forward();
	}

	@When("I verfy {string} header exist")
	public void i_verfy_header_exist(String expectedText) {
		WebElement quizHeader = locatorUtils.waitForHeaderWithText(expectedText, "h3");
		assertEquals(expectedText, quizHeader.getText());
		waitUtils.teraHold();
	}

}
