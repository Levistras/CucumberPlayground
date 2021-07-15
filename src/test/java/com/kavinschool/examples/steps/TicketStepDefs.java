package com.kavinschool.examples.steps;

import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kavinschool.examples.hooks.DriverFactory;
import com.kavinschool.examples.pages.ConfirmationPage;
import com.kavinschool.examples.pages.OpenNewTicketPage;
import com.kavinschool.examples.pages.SupportCenterHomePage;
import com.kavinschool.examples.utils.DriverUtils;
import com.kavinschool.examples.utils.LocatorUtils;
import com.kavinschool.examples.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketStepDefs {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private WebDriver driver;
	private LocatorUtils locatorUtils;
	private WaitUtils waitUtils;
	private OpenNewTicketPage openNewTicketPage;
	private SupportCenterHomePage supportCenterHomePage;
	private ConfirmationPage confirmationPage ;

	public TicketStepDefs(DriverFactory driverFactory) {
		this.driver = driverFactory.getDriver();
		this.locatorUtils = new LocatorUtils(driver);
		this.waitUtils = new WaitUtils(driver);
		this.supportCenterHomePage = new SupportCenterHomePage(driver);
		PageFactory.initElements(driver, supportCenterHomePage);
	}

	@Then("I verify the header text contains {string}")
	public void i_verify_the_header_text_contains(String textMsg) {
		WebElement header = locatorUtils.waitForHeaderWithText(textMsg, "h1");
		Assert.assertEquals(header.getText(), textMsg);
	}

	@Then("I verify the paragraph contains {string}")
	public void i_verify_the_paragraph_contains(String text) {
		WebElement para = locatorUtils.waitForParagraphContainsText(text);
		Assert.assertEquals(para.getText(), text);

	}

	@When("I clicked on the Open New Ticket button")
	public void i_clicked_on_the_open_new_ticket_button() {
		openNewTicketPage = supportCenterHomePage.clickOpenNewTicketButtonLink();

	}

	@Then("I wait for {string} header text to show")
	public void i_will_wait_for(String text) {
		openNewTicketPage.verifyPageLoaded(text);

	}

	@Then("I verify paragraph text exists {string}")
	public void i_will_verify_text_exists(String text) {
		WebElement paragraph = locatorUtils.waitForParagraphContainsText(text);
		Assert.assertEquals(text, paragraph.getText());
	}

	@Then("I verify h3 text exists {string}")
	public void i_will_verify_h3_text_exists(String text) {
		WebElement h3 = locatorUtils.waitForHeaderWithText(text, "h3");
		Assert.assertEquals(text, h3.getText());
	}

	@Then("I verify span contains text {string}")
	public void i_verify_span_contains_text_label_exist(String text) {
		WebElement span = locatorUtils.waitForSpanContainsText(text);
		Assert.assertTrue("Span does not contain expected text:" + text, span.getText().contains(text));
	}

	@Then("I verify bold label exist {string}")
	public void i_verify_bold_label_exist(String text) {
		WebElement bold = locatorUtils.waitForBoldTextContains(text,"//div");
		Assert.assertTrue("Span does not contain expected text:" + text, bold.getText().contains(text));
	}
	
	@When("I verify div contains text {string}")
	public void i_verify_div_contains_text(String text) {
		WebElement div = locatorUtils.waitForDivWithText(text);
		Assert.assertTrue("Span does not contain expected text:" + text, div.getText().contains(text));
	}

	@When("I type email address {string} value")
	public void i_type_email_address_value(String email) {
		openNewTicketPage.typeEmailAddressField(email);
	}

	@Then("I type full name {string} value")
	public void i_type_full_name_value(String name) {
		openNewTicketPage.typeFullNameTextField(name);
	}

	@Then("I type telephone {string} and {string} value")
	public void i_type_telephone_and_value(String phone, String ext) {
		openNewTicketPage.typePhoneNumberTextField(phone);
		openNewTicketPage.typePhoneNumberExtTextField(ext);
	}

	@Then("I type select a help topic {string} from dropdown")
	public void i_type_select_a_help_topic_from_dropdown(String topic) {
		openNewTicketPage.selectHelpTopicDropDownListField(topic);
	}

	@Then("I type a subject {string} value")
	public void i_type_a_subject_value(String subjectText) {
		openNewTicketPage.typeIssueSummaryField(subjectText);
	}

	@Then("I type a message {string} value")
	public void i_type_a_message_value(String issueMessage) {
		openNewTicketPage.typeIssueTextField(issueMessage);
		waitUtils.nanoHold();
	}

	@Then("I click on the Create Ticket button")
	public void i_click_on_the_create_ticket_button() {
		waitUtils.megaHold();
		confirmationPage = openNewTicketPage.clickCreateTicketButton();
	}

	@When("I waited for a new created message shows up with {string}")
	public void i_waited_for_a_new_created_message_shows_up_with(String text) {
		confirmationPage.verifyPageLoaded(text);
		Assert.assertEquals(text, confirmationPage.getNotice());
	}

	@When("I verify that the message contains first name {string}")
	public void i_verify_that_the_message_contains_first_name(String expectedText) {
		String message = confirmationPage.getConfirmationMessage();
		log.info("message :{}",message);
		String firstName = expectedText.split("\\s")[0];
		log.info("firstName :{}",firstName);
		Assert.assertTrue("Name not found in confirmation message",
				message.contains(firstName));
		waitUtils.megaHold();
	}

	@Then("I attach a file {string}")
	public void i_attach_a_file(String fileName) throws FileNotFoundException {
		openNewTicketPage.attachFile(fileName);
		waitUtils.megaHold();
	}
}
