package com.gcit.tests.amazon;

import com.gcit.Base.BaseSetup;
import com.gcit.annotations.FrameWorkAnnotations;
import com.gcit.enums.CategoryType;
import com.gcit.enums.ConfigProperties;
import com.gcit.pages.amazon.AmazonHomePage;
import com.gcit.utils.PropertyUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;


import static com.gcit.driver.DriverManager.getThreaddriver;

/**
 * Contains the test cases of Amazon website
 * 
 * @author Jeeva Chandhran
 * May 26, 2022 
 * @version 1.0
 * @since 1.0<br>
 * @see BaseSetup
 */
public final class HomePageTest extends BaseSetup {
	/**
	 * Private constructor to avoid external instantiation
	 */
    private HomePageTest(){}

    /**
	 * Test Name mentioned here should match the column name "TestCaseName" in database.This is mandatory to run this
	 * test. Otherwise it will be ignored. <p>
	 * The match has to be there in both of the RunnerList Json and TestCaseName
	 * Set the authors who have the created the test which will be logged to the reports.
	 * Set the category which this particular test case belongs to
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @param map HashMap containing all the values of test data needed to run the tests
	 */
    
    @FrameWorkAnnotations(testAuthor = {"Jeeva"}, catagory = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void TC001_amazonHomePageTest(HashMap<String,String> map){

        getThreaddriver().get(PropertyUtils.getValue(ConfigProperties.AMAZONURL));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        String title = new AmazonHomePage().clickHamburger().clickOnFirstSubMenu(map.get("searchItem"), map.get("searchItem")).clickOnSubMenu(map.get("subSearchItem"), map.get("subSearchItem")).getCurrentTitle();
		Assertions.assertThat(title).isNotNull().isNotBlank();
    }

    /**
	 * Test Name mentioned here should match the column name "TestCaseName" in database.This is mandatory to run this
	 * test. Otherwise it will be ignored. <p>
	 * The match has to be there in both of the RunnerList Json and TestCaseName
	 * Set the authors who have the created the test which will be logged to the reports.
	 * Set the category which this particular test case belongs to
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @param map HashMap containing all the values of test data needed to run the tests
	 */
    @FrameWorkAnnotations(testAuthor = {"Jeeva"}, catagory = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void TC003_amazonHomePageTest(HashMap<String,String> map){
        getThreaddriver().get(PropertyUtils.getValue(ConfigProperties.AMAZONURL));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        String title = new AmazonHomePage().clickHamburger().clickOnFirstSubMenu(map.get("searchItem"), map.get("searchItem")).clickOnSubMenu(map.get("subSearchItem"), map.get("subSearchItem")).getCurrentTitle();
        Assertions.assertThat(title).isNotNull().isNotBlank();
    }
}
