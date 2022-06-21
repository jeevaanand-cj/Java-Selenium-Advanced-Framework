package com.gcit.pages.amazon;

import com.gcit.enums.WaitStrategy;
import com.gcit.pages.basepage.BasePageActions;
import com.gcit.utils.DynamicXpathUtils;
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
public final class AmazonHamburgerPage extends BasePageActions {

    //dynamic xpath handling
    private String linkSubMenu = "//a[text()='%s']";
    private String linkFirstSubMenu = "//div[text()='%s']";

    public AmazonHamburgerPage clickOnFirstSubMenu(String menuText, String textVerify){
        String dynamicPath = DynamicXpathUtils.getDynamicXpath(linkFirstSubMenu , menuText);
        click(By.xpath(dynamicPath), WaitStrategy.CLICKABLE, menuText);
        if (menuText.contains(textVerify)){
            return this;
        }
        else
            return null;
    }

    public AmazonLaptopsPage clickOnSubMenu(String submenuText, String textVerify){
        String dynamicPath = DynamicXpathUtils.getDynamicXpath(linkSubMenu , submenuText);
        click(By.xpath(dynamicPath), WaitStrategy.CLICKABLE, submenuText);
        if (submenuText.contains(textVerify)){
            return new AmazonLaptopsPage();
        }
        else
            return null;
    }
}
