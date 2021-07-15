package com.kavinschool.examples.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportCenterHomePage {
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "a.blue.button")
	@CacheLookup
	private WebElement openNewTicketButton;

	@FindBy(css = "a.green.button")
	@CacheLookup
	private WebElement checkTicketStatus;

	@FindBy(id = "poweredBy")
	@CacheLookup
	private WebElement helpdeskSoftwarePoweredByOsticket;



	private final String pageLoadedText = "In order to streamline support requests and better serve you, we utilize a support ticket system";

	private final String pageUrl = "/ticket/index.php";

	@FindBy(css = "a[href='/ticket/login.php']")
	@CacheLookup
	private WebElement signIn;



	public SupportCenterHomePage() {
	}

	public SupportCenterHomePage(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public SupportCenterHomePage(WebDriver driver, int timeout) {
		super();
		this.driver = driver;
		this.timeout = timeout;
	}

	/**
	 * Click on Check Ticket Status Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public OpenNewTicketPage clickOpenNewTicketButtonLink() {
		openNewTicketButton.click();
		OpenNewTicketPage target = new OpenNewTicketPage(driver);
		PageFactory.initElements(driver, target);
		return target;
	}

	/**
	 * Click on Check Ticket Status Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public SupportCenterHomePage clickCheckTicketStatusButtonLink() {
		checkTicketStatus.click();
		return this;
	}

	/**
	 * Click on Helpdesk Software Powered By Osticket Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public SupportCenterHomePage clickHelpdeskSoftwarePoweredByOsticketLink() {
		helpdeskSoftwarePoweredByOsticket.click();
		return this;
	}


	/**
	 * Click on Sign In Link.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public SupportCenterHomePage clickSignInLink() {
		signIn.click();
		return this;
	}


	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the SupportCenterHomePage class instance.
	 */
	public SupportCenterHomePage verifyPageLoaded() {
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
	 * @return the SupportCenterHomePage class instance.
	 */
	public SupportCenterHomePage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
