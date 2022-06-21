package com.gcit.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 * 
 * May 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.factories.ExplicitWaitFactory
 * @see com.gcit.pages.basepage.BasePageActions
 */
public enum WaitStrategy {

    CLICKABLE,
    PRESENCE,
    VISIBLE,
    NONE
}
