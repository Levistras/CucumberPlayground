package com.kavinschool.examples.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {
	private WebDriver driver;
	private int timeout = 15;
	private final String pageUrl = "/ticket/open.php";

	@FindBy(id = "msg_notice")
	private WebElement notice;
	

	@FindBy(xpath = "//div[@id='content']/div[2]")
	private WebElement confirmationMsg;
	
	public ConfirmationPage() {
		super();
	}

	public ConfirmationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public ConfirmationPage(WebDriver driver, int timeout) {
		super();
		this.driver = driver;
		this.timeout = timeout;
	}
	
	public String getConfirmationMessage() {
		return confirmationMsg.getText();
	}
	
	public String getNotice() {
		return notice.getText();
	}
	
	/**
	 * Verify that the page loaded completely.
	 * @param text 
	 *
	 * @return the OpenNewTicketPage class instance.
	 */
	public ConfirmationPage verifyPageLoaded(String text) {
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
	public ConfirmationPage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

}
