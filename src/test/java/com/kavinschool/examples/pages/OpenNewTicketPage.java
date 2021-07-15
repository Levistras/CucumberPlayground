package com.kavinschool.examples.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenNewTicketPage {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	private final String pageUrl = "/ticket/open.php";

	@FindBy(xpath = "//input[@value='Create Ticket']")
	@CacheLookup
	private WebElement createTicket;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	private WebElement emailAddress;

	@FindBy(css = "[type='text'][placeholder]")
	@CacheLookup
	private WebElement fullName;

	@FindBy(xpath = "//span[contains(.,'Phone Number')]//following-sibling::input[@type='tel']")
	@CacheLookup
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[contains(.,'Phone Number')]//following-sibling::input[contains(@name,'ext')]")
	@CacheLookup
	private WebElement phoneNumberExt;

	@FindBy(id = "topicId")
	@CacheLookup
	private WebElement helpTopicSelect;
	
	@FindBy(xpath = "//span[contains(.,'Issue Summary')]//following-sibling::input[@type='text']")
	@CacheLookup
	private WebElement issueSummary;

	@FindBy(xpath = "//div[contains(@class,'redactor-in')]/p")
	@CacheLookup
	private WebElement issueText;
	
	@FindBy(xpath = "//div[@class='dropzone']/input[1]")
	@CacheLookup
	private WebElement chooseFrom;
	
	@FindBy(name = "reset")
	@CacheLookup
	private WebElement resetButton;

	@FindBy(name = "cancel")
	@CacheLookup
	private WebElement cancel;

	public OpenNewTicketPage() {
	}

	public OpenNewTicketPage(WebDriver driver) {
		this();
		this.driver = driver;
	}
	
	public OpenNewTicketPage(WebDriver driver,int timeout) {
		this(driver);
		this.timeout = timeout;
	}
	
	public OpenNewTicketPage(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public OpenNewTicketPage(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Cancel Button.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public SupportCenterHomePage clickCancelButton() {
		SupportCenterHomePage target = new SupportCenterHomePage(driver, timeout);
		PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Click on Create Ticket Button.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public ConfirmationPage clickCreateTicketButton() {
		createTicket.click();
		ConfirmationPage target = new ConfirmationPage(driver, timeout);
		PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage fill() {
		setEmailAddressField();
		setFullNameTextField();
		setPhoneNumberTextField();
		setPhoneNumberExtTextField();
		setHelpTopicDropDownListField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the ConfirmationPage class instance.
	 */
	public ConfirmationPage fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Email Address Email field.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage setEmailAddressField() {
		return typeEmailAddressField(data.get("EMAIL_ADDRESS"));
	}

	/**
	 * Set value to Email Address Email field.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage typeEmailAddressField(String emailAddressValue) {
		emailAddress.sendKeys(emailAddressValue);
		return this;
	}

	/**
	 * Set default value to Full Name Text field.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage setFullNameTextField() {
		return typeFullNameTextField(data.get("FULL_NAME"));
	}

	/**
	 * Set value to Full Name Text field.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage typeFullNameTextField(String fullNameValue) {
		fullName.sendKeys(fullNameValue);
		return this;
	}

	public OpenNewTicketPage setPhoneNumberTextField() {
		return typePhoneNumberTextField(data.get("PHONE_NUMBER"));
	}

	public OpenNewTicketPage typePhoneNumberTextField(String phoneNumberValue) {
		phoneNumber.sendKeys(phoneNumberValue);
		return this;
	}

	public OpenNewTicketPage setPhoneNumberExtTextField() {
		return typePhoneNumberExtTextField(data.get("PHONE_NUMBER_EXT"));
	}

	public OpenNewTicketPage typePhoneNumberExtTextField(String extention) {
		phoneNumberExt.sendKeys(extention);
		return this;
	}
	
	public OpenNewTicketPage typeIssueSummaryField(String issueSummaryText) {
		issueSummary.sendKeys(issueSummaryText);
		return this;
	}
	
	public OpenNewTicketPage typeIssueTextField(String issueTextValue) {
		issueText.sendKeys(issueTextValue);
		return this;
	}

	public OpenNewTicketPage setHelpTopicDropDownListField() {
		return selectHelpTopicDropDownListField(data.get("HELP_TOPIC"));
	}

	public OpenNewTicketPage selectHelpTopicDropDownListField(String option) {
		new Select(helpTopicSelect).selectByVisibleText(option);
		return this;
	}

	/**
	 * Set Phone Number Ext Reset field.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage clickResetButton() {
		resetButton.click();
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the ConfirmationPage class instance.
	 */
	public ConfirmationPage submit() {
		clickCreateTicketButton();
		ConfirmationPage target = new ConfirmationPage(driver, timeout);
		PageFactory.initElements(driver, target);
		return target;
	}

	public OpenNewTicketPage unsetHelpTopicDropDownListField() {
		return deselectHelpTopicDropDownListField(data.get("HELP_TOPIC"));
	}

	public OpenNewTicketPage deselectHelpTopicDropDownListField(String option) {
		new Select(helpTopicSelect).deselectByVisibleText(option);
		return this;
	}

	public OpenNewTicketPage attachFile(String fileName) throws FileNotFoundException {
		String dir = System.getProperty("user.dir");
		String uploadFile = dir + "/src/test/resources/" + fileName;
        log.info("uploadFile:{}",uploadFile);
		chooseFrom.sendKeys(uploadFile);
		return this;
	}
	
	/**
	 * Verify that the page loaded completely.
	 * @param text 
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage verifyPageLoaded(String text) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(text);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public OpenNewTicketPage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
