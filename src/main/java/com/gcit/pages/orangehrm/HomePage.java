package com.gcit.pages.orangehrm;

import com.gcit.enums.WaitStrategy;
import com.gcit.pages.basepage.BasePageActions;
import org.openqa.selenium.By;

/**
 * Page is used to do the web page actions based on the used requirements 
 * 
 * @author Jeeva Chandhran
 * May 25, 2022
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.pages.basepage.BasePageActions
 */
public final class HomePage extends BasePageActions {

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[contains(text(),'Logout')]");

    private final By searchIcon = By.xpath("(//button[contains(@id,'search-icon')])[position()=1]");
    private final By searchInputBox = By.xpath("(//input[@placeholder='Search'])[position()=1]");
    private final By searchPageVerify =By.xpath( "//input[contains(@id,'search_input')]");
    private final By totalResults= By.xpath("//div[@class='results']");

    public HomePage clickWelcome(){
        click(linkWelcome, WaitStrategy.PRESENCE,"Welcome button");
        //replacement of thread.sleep
        return this;
    }

    public DashboardPage clickLogout(){
//        new WebDriverWait(getThreaddriver(),Duration.ofSeconds(10))
//        .until(d->d.findElement(linkLogout).isEnabled()); //java - 8 lambda concept
        click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");
        return new DashboardPage();
    }



}
