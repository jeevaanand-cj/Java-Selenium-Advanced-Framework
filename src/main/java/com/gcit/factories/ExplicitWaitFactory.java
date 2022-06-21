package com.gcit.factories;

import com.gcit.constants.FrameWorkConstants;
import com.gcit.enums.WaitStrategy;
import com.gcit.exceptions.FrameWorkExceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.gcit.driver.DriverManager.getThreaddriver;

/**
 * Explicit wait factory produces different waits before operating on webElement
 * 
 * Jan 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0
 * @see com.gcit.pages.basepage.BasePageActions
 */
public final class ExplicitWaitFactory {
	
	/**
     * Private constructor to avoid external instantiation
     */
    private ExplicitWaitFactory(){}

	/**
	 * 
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @param waitStrategy Strategy to be applied to find a webElement {@link com.gcit.enums.WaitStrategy}
	 * @param by By locator of the webElement
	 * @return webElement Locates and return the webElement
	 */
    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){

        WebElement element;
        WebDriverWait webDriverWait = new WebDriverWait(getThreaddriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitwait()));
        try {
            switch (waitStrategy){

                case CLICKABLE:
                    element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
                    break;
                case PRESENCE:
                    element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
                    break;
                case VISIBLE:
                    element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
                    break;
                case NONE:
                    element = getThreaddriver().findElement(by);
                    break;
                default:
                    throw new IllegalStateException("Please enter correct wait option from the list: " + waitStrategy);
            }
        }
        catch (TimeoutException e){
            throw new FrameWorkExceptions("Wait time exceed, Unable to locate the element", e);
        }

        return element;
    }


}
