package com.gcit.pages.basepage;

import com.gcit.enums.WaitStrategy;
import com.gcit.factories.ExplicitWaitFactory;
import com.gcit.reports.ExtentLogger;
import org.openqa.selenium.By;

import static com.gcit.driver.DriverManager.getThreaddriver;
/**
 * BasePage contains all command method for do the selenium related actions
 * 
 * @author Jeeva Chandhran
 * May 25, 2022
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.factories.ExplicitWaitFactory
 */

public class BasePageActions {

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webElement and
	 * writes the pass even to the extent report.
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @param by By Locator of the webElement
	 * @param waitStrategy Strategy to find webElement. Known  strategies {@link com.gcit.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
    protected void click(By by, WaitStrategy waitStrategy, String elementname) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
        try {
            ExtentLogger.pass(elementname+" is clicked", true);
        }
        catch (Exception e){
			ExtentLogger.fail("Unable to click on "+elementname);
            e.printStackTrace();
        }


    }

    /**
	 * Locates element by given wait strategy, sends the value to located webElement and
	 * writes the pass even to the extent report.
	 * @author Jeeva Chandhran
	 * May 26,2022
	 * @param by By Locator of the webElement
	 * @param value value to be send the text box
	 * @param waitStrategy Strategy to find webElement. Known  strategies {@link com.gcit.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
    protected void sendKeys(By by,String value, WaitStrategy waitStrategy, String elementname) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
        try {
            ExtentLogger.pass("Given value "+value+" is entered successfully in "+elementname+" field", true);
        } catch (Exception e) {
			ExtentLogger.fail("Unable to insert/pass the given text in  "+elementname);
            e.printStackTrace();
        }
    }
    /**
	 * Locates element by given wait strategy, return the value of located webElement and
	 * writes the pass even to the extent report.
	 * @author Jeeva Chandhran
	 * May 26,2022
	 * @param by By Locator of the webElement
	 * @param waitStrategy Strategy to find webElement. Known  strategies {@link com.gcit.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
    protected void verifyElement(By by, WaitStrategy waitStrategy, String elementname) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by);

        try {
            ExtentLogger.pass(elementname+" successfully verified", true);
        } catch (Exception e) {
			ExtentLogger.fail("Unable to verify the element  "+elementname);
            e.printStackTrace();
        }
    }
    /**
	 * Return page title of webPage in String
	 * 
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @return Page title of the webPage where the Selenium is currently interacting.
	 */
    protected String getTitle() {
        return getThreaddriver().getTitle();
    }

}
