package com.gcit.tests.google;

import com.gcit.Base.BaseSetup;
import static com.gcit.driver.DriverManager.*;

import com.gcit.enums.ConfigProperties;
import com.gcit.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class GoogleTest extends BaseSetup {
    private GoogleTest(){}

    @Test
    public void googleTest() throws Exception {
        getThreaddriver().get(PropertyUtils.getValue(ConfigProperties.AMAZONURL));
        getThreaddriver().findElement(By.name("q")).sendKeys("Jeeva Chandran", Keys.ENTER);
        String title = getThreaddriver().getTitle();
        // assertJ assertions- single line multi validations
        assertThat(title).as("Object is actually null").isNotNull()
                .as("It does not contains as expected: ").containsIgnoringCase("google search")
                .matches("Jeeva Chandran - Google Search")
                .hasSizeBetween(15 , 40);
        // TestNG assertion
        //Assert.assertTrue(Objects.nonNull(title));
        //Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));// w-->[a-z, A-Z, 0-9], .--> any of this,
    }


}
