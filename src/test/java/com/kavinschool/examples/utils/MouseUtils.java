package com.kavinschool.examples.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.invoke.MethodHandles;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MouseUtils {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private WebDriver driver;
	

    public MouseUtils(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void mouseHover(final WebElement element) {
        final Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
	}

    public void mouseHoverClickItem(final WebElement hoverElement,
                                           final WebElement clickElement) {
        final Actions action = new Actions(driver);
        action.moveToElement(hoverElement).moveToElement(clickElement).click().build().perform();
    }

    public void moveToElement(final WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }

    public void rightClick(final WebElement element) {
        final Actions action = new Actions(driver).contextClick(element);
        action.build().perform();
    }

    public void rightClickAndSelectOption(final WebElement element,
                                                 final int OptionToSelect) {
        final Actions action = new Actions(driver).contextClick(element);
        for (int i = 0; i < OptionToSelect; i++) {
            action.sendKeys(Keys.ARROW_DOWN);
        }
        action.build().perform();
    }

    public void doubleClick(final WebElement element) {
        final Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }

    public void dragAndDrop(WebDriver driver, WebElement source, WebElement dest) throws AWTException {
        new Actions(driver).dragAndDrop(source, dest).release().build().perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void dragAndDropUsingPos(WebDriver driver, WebElement source, WebElement dest) {
        int x = dest.getLocation().x;
        int y = dest.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(source)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(source)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(dest)
                .moveByOffset(x, y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
    }

    public void dragAndDropUsingClickAndHold(final WebElement sourceElement,
                                                    final WebElement TargetElement) {
        final Actions action = new Actions(driver);
        final Action dragAndDrop = action.moveToElement(sourceElement).clickAndHold(sourceElement).pause(500)
                .moveToElement(TargetElement, 1, 50).release(TargetElement).pause(500).build();
        dragAndDrop.perform();
    }

    public void scrollIntoView(final WebDriver driver,final WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            WaitUtils.delay(500);
        } catch(MoveTargetOutOfBoundsException e) {
            log.error("Moving out of bound!!");
        }
    }

    public void clickAt(final By byMethod) {
        final WebElement element = driver.findElement(byMethod);
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element).click().build();
        action.perform();
    }

    public void clickAt(final By byMethod, final int xOffset,
                        final int yOffset) {
        final WebElement element = driver.findElement(byMethod);
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element, xOffset, yOffset).click().build();
        action.perform();
    }

    public void clickAt(final WebElement element) {
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element).click().build();
        action.perform();
    }

    public void clickAt(final WebElement element, final int xOffset,
                        final int yOffset) {
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element, xOffset, yOffset).click().build();
        action.perform();
    }

}
