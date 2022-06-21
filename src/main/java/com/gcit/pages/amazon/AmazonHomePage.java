package com.gcit.pages.amazon;

import com.gcit.enums.WaitStrategy;
import com.gcit.pages.basepage.BasePageActions;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
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
public final class AmazonHomePage extends BasePageActions {

    private final By linkHamburger  = By.id("nav-hamburger-menu");

    public @NotNull AmazonHamburgerPage clickHamburger(){
        click(linkHamburger, WaitStrategy.CLICKABLE, "Ham burger link");
        return new AmazonHamburgerPage();
    }
}
