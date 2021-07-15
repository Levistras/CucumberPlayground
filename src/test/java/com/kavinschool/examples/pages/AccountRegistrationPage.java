package com.kavinschool.examples.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private final String pageLoadedText = "Use the forms below to create or update the information we have on file for your account";

	private final String pageUrl = "/ticket/account.php?do=create";

	@FindBy(css = "button.action-button")
	@CacheLookup
	private WebElement autoDetect;

	@FindBy(xpath = "//input[@value='Cancel']")
	@CacheLookup
	private WebElement cancel;

	@FindBy(xpath = "//span[contains(.,'Email Address')]//following-sibling::input[@type='email']")
	@CacheLookup
	private WebElement emailAddress;

	@FindBy(xpath = "//span[contains(.,'Full Name')]//following-sibling::input[@type='text']")
	@CacheLookup
	private WebElement fullName;

	@FindBy(xpath = "//input[@type='tel']")
	@CacheLookup
	private WebElement phoneNumber;

	@FindBy(xpath = "//input[contains(@name,'ext')]")
	@CacheLookup
	private WebElement phoneNumberExt;

	@FindBy(id = "timezone-dropdown")
	@CacheLookup
	private WebElement timeZoneDropDown;

	@FindBy(name = "passwd1")
	@CacheLookup
	private WebElement createPassword;

	@FindBy(name = "passwd2")
	@CacheLookup
	private WebElement confirmNewPassword;

	@FindBy(xpath = "//input[@value='Register']")
	@CacheLookup
	private WebElement register;

	public AccountRegistrationPage() {
	}

	public AccountRegistrationPage(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public AccountRegistrationPage(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public AccountRegistrationPage(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Auto Detect Button.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage clickAutoDetectButton() {
		autoDetect.click();
		return this;
	}

	/**
	 * Click on Cancel Button.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public SupportCenterHomePage clickCancelButton() {
		cancel.click();
		SupportCenterHomePage target = new SupportCenterHomePage(driver, timeout);
		PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Click on Register Button.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public RegistrationSuccessfulPage clickRegisterButton() {
		register.click();
		RegistrationSuccessfulPage target = new RegistrationSuccessfulPage(driver, timeout);
		PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage fill() {
		setEmailAddressField();
		setFullNameTextField();
		setPhoneNumberTextField();
		setPhoneNumberExtTextField();
		setTimeZoneDropDownListField();
		setCreatePasswordField();
		setConfirmPasswordField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the RegistrationSuccessfulPage class instance.
	 */
	public RegistrationSuccessfulPage fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Email Address Email field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setEmailAddressField() {
		return typeEmailAddressField(data.get("EMAIL_ADDRESS"));
	}

	/**
	 * Set value to Email Address Email field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage typeEmailAddressField(String emailAddressValue) {
		emailAddress.sendKeys(emailAddressValue);
		return this;
	}

	/**
	 * Set default value to Full Name Text field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setFullNameTextField() {
		return typeFullNameTextField(data.get("FULL_NAME"));
	}

	/**
	 * Set value to Full Name Text field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage typeFullNameTextField(String fullNameValue) {
		fullName.sendKeys(fullNameValue);
		return this;
	}

	/**
	 * Set default value to Phone Number Ext Text field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setPhoneNumberTextField() {
		return typePhoneNumberTextField(data.get("PHONE_NUMBER"));
	}

	/**
	 * Set value to Phone Number Ext Text field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage typePhoneNumberTextField(String phoneNumberExt1Value) {
		phoneNumber.sendKeys(phoneNumberExt1Value);
		return this;
	}

	/**
	 * Set default value to Phone Number Ext Text field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setPhoneNumberExtTextField() {
		return typePhoneNumberExtTextField(data.get("PHONE_NUMBER_EXT"));
	}

	/**
	 * Set value to Phone Number Ext Text field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage typePhoneNumberExtTextField(String phoneNumberExtValue) {
		phoneNumberExt.sendKeys(phoneNumberExtValue);
		return this;
	}

	/**
	 * Set default value to Phone Number Ext Drop Down List field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setTimeZoneDropDownListField() {
		return selectTimeZoneDropDownListField(data.get("TIME_ZONE"));
	}

	/**
	 * Set value to Phone Number Ext Drop Down List field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage selectTimeZoneDropDownListField(String option) {
		new Select(timeZoneDropDown).selectByVisibleText(option);
		return this;
	}

	/**
	 * Set default value to Phone Number Ext Password field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setCreatePasswordField() {
		return typeCreatePasswordField(data.get("PASSWORD"));
	}

	/**
	 * Set value to Phone Number Ext Password field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage typeCreatePasswordField(String phoneNumberExt4Value) {
		createPassword.sendKeys(phoneNumberExt4Value);
		return this;
	}

	/**
	 * Set default value to Phone Number Ext Password field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage setConfirmPasswordField() {
		return typeConfirmPasswordField(data.get("PASSWORD"));
	}

	/**
	 * Set value to Phone Number Ext Password field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage typeConfirmPasswordField(String confirmPassword) {
		confirmNewPassword.sendKeys(confirmPassword);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the RegistrationSuccessfulPage class instance.
	 */
	public RegistrationSuccessfulPage submit() {
		clickRegisterButton();
		RegistrationSuccessfulPage target = new RegistrationSuccessfulPage(driver, timeout);
		PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Unset default value from Phone Number Ext Drop Down List field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage unsetTimeZoneDropDownListField() {
		return deselectTimeZoneDropDownListField(data.get("TIME_ZONE"));
	}

	/**
	 * Unset value from Phone Number Ext Drop Down List field.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage deselectTimeZoneDropDownListField(String option) {
		new Select(timeZoneDropDown).deselectByVisibleText(option);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the AccountRegistrationPage class instance.
	 */
	public AccountRegistrationPage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
