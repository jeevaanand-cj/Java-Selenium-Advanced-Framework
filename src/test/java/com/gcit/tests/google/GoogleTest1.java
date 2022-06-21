package com.gcit.tests.google;

import com.gcit.Base.BaseSetup;
import com.gcit.driver.DriverManager;
import com.gcit.enums.ConfigProperties;
import com.gcit.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class GoogleTest1 extends BaseSetup {
    private GoogleTest1(){}

    @Test
    public void googleTest() throws Exception {
        DriverManager.getThreaddriver().get(PropertyUtils.getValue(ConfigProperties.AMAZONURL));
        DriverManager.getThreaddriver().findElement(By.name("q")).sendKeys("Jeeva Anand", Keys.ENTER);
    }


}
