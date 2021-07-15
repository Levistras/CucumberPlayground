package com.kavinschool.examples.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationSuccessfulPage {
	private WebDriver driver;
	private int timeout = 15;

	private final String pageLoadedText = "Thanks for registering for an account";

	private final String pageUrl = "/ticket/account.php";

	public RegistrationSuccessfulPage() {
	}

	public RegistrationSuccessfulPage(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public RegistrationSuccessfulPage(WebDriver driver, int timeout) {
		this(driver);
		this.timeout = timeout;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the RegistrationSuccessfulPage class instance.
	 */
	public RegistrationSuccessfulPage verifyPageLoaded() {
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
	 * @return the RegistrationSuccessfulPage class instance.
	 */
	public RegistrationSuccessfulPage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
