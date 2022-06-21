package com.gcit.tests.orangehrm;

import com.gcit.Base.BaseSetup;
import com.gcit.annotations.FrameWorkAnnotations;
import com.gcit.enums.CategoryType;
import com.gcit.enums.ConfigProperties;
import com.gcit.pages.orangehrm.DashboardPage;
import com.gcit.utils.PropertyUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;


import static com.gcit.driver.DriverManager.getThreaddriver;

/**
 * Contains the test cases of Orange hrm website
 * 
 * @author Jeeva Chandhran
 * May 26, 2022 
 * @version 1.0
 * @since 1.0<br>
 * @see BaseSetup
 */
public final class OrangeHrmTests extends BaseSetup {

	/**
	 * Private constructor to avoid external instantiation
	 */
    private OrangeHrmTests() {
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
    @Test // (dataProvider = "getJsonTestData", dataProviderClass = DataProviderUtils.class,retryAnalyzer = RetryFailedTest.class, priority = 1) -- > this will set at run time by annotation transformer
    public void TC001_dashboardAccessTest(HashMap<String,String> map) throws Exception {

        getThreaddriver().get(PropertyUtils.getValue(ConfigProperties.ORANGEURL));
        String page_title = new DashboardPage().enterUsername(map.get("userFirstName")).enterPassword(map.get("password")).clickLogin()
                            .clickWelcome().clickLogout()
                            .getPageTitle();
        Assertions.assertThat(page_title).isEqualTo("OrangeHRM");
    }

    /**
	 * Test Name mentioned here should match the column name "TestCaseName" in database.This is mandatory to run this
	 * test. Otherwise it will be ignored. <p>
	 * The match has to be there in both of the RunnerList Json and TestCaseName
	 * Set the authors who have the created the test which will be logged to the reports.
	 * Set the category which this particular test case belongs to
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @param data HashMap containing all the values of test data needed to run the tests
	 */
    @FrameWorkAnnotations(testAuthor = {"Jeeva"}, catagory = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test // (dataProvider = "getJsonTestData", dataProviderClass = DataProviderUtils.class,retryAnalyzer = RetryFailedTest.class,  priority = 2)--> -- > this will set at run time by annotation transformer
    public void TC003_dashboardAccessTest(HashMap<String,String> map) throws Exception {

        getThreaddriver().get(PropertyUtils.getValue(ConfigProperties.ORANGEURL));
        String page_title = new DashboardPage().enterUsername(map.get("userFirstName")).enterPassword(map.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getPageTitle();
        Assertions.assertThat(page_title).isEqualTo("OrangeHRM");
    }
}
