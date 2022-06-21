package com.gcit.pages.orangehrm;

import com.gcit.enums.WaitStrategy;
import com.gcit.pages.basepage.BasePageActions;
import org.openqa.selenium.By;

import static com.gcit.driver.DriverManager.*;

/**
 * Page is used to do the web page actions based on the used requirements 
 * 
 * @author Jeeva Chandhran
 * May 25, 2022
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.pages.basepage.BasePageActions
 */
public final class DashboardPage extends BasePageActions {

    /* Locator orders
    id
    name
    classname
    link text
    partial link text
    css or xpath
     */

    private final By textboxUsername = By.id("txtUsername");
    private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By buttonLogin = By.id("btnLogin");

    //Web elements
    private By personalTab =By.xpath("(//a[contains(@id,'Personal')])[position()=1]");
    private By dashBoardVerification = By.xpath("(//button[contains(@id,'Why-Verizon')])[position()=1]");
    private By shopButton = By.xpath("(//button[contains(@id,'Shop')])[position()=1]");
    private By shopbtnVerify =By.xpath("//div[contains(@class,'grouping-active')]/child::ul[contains(@class,'column-highlight')]");
    private By deviceBtn = By.xpath("(//div[contains(@class,'grouping-active')]/child::ul[contains(@class,'column-highlight')]//child::a[contains(text(),'Devices')])[position()=1]");
    private By five_GphoneBtn = By.xpath("//a[contains(text(),'5G phones')]");


    public DashboardPage enterUsername(String username) {
        sendKeys(textboxUsername, username, WaitStrategy.VISIBLE, "username");
        return this;
    }

    public DashboardPage enterPassword(String password) {
        sendKeys(textboxPassword, password, WaitStrategy.VISIBLE, "password");
        return this;
    }

    public HomePage clickLogin() {
        click(buttonLogin, WaitStrategy.CLICKABLE, "login button");
        return new HomePage();
    }

    public DashboardPage dashBoardNavigation() {
        verifyElement(dashBoardVerification,WaitStrategy.VISIBLE, "Verizon home page");
        return this;
    }

    public DashboardPage clickPersonalTab() {
        click(personalTab, WaitStrategy.CLICKABLE, "Personal tab button");
        return this;
    }

    public DashboardPage shopPageNavigation() {
        click(shopButton, WaitStrategy.CLICKABLE, "Shop button");
        verifyElement(shopbtnVerify,WaitStrategy.VISIBLE, "Shop page");
        return this;
    }

    public HomePage mobileSectionNavigation() {
        click(deviceBtn, WaitStrategy.CLICKABLE, "Devices button");
        verifyElement(five_GphoneBtn,WaitStrategy.VISIBLE, "5G phones page");
        click(five_GphoneBtn, WaitStrategy.CLICKABLE, "5G phones button");
        return new HomePage();
    }


    public String getPageTitle(){
        return getThreaddriver().getTitle();
    }

}
