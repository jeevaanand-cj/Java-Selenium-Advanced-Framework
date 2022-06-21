package com.gcit.reports;

import com.aventstack.extentreports.ExtentTest;
/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * May 27, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.driver.Driver
 */

public final class ExtentManager extends ThreadLocal<ExtentTest> {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extenttest= new ThreadLocal<>();

    /**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author Jeeva Chandhran
	 * May 27, 2022
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
    static ExtentTest getExtentTest() {
        return extenttest.get();
    }

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author Jeeva Chandhran
	 * May 27, 2022
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 */
    static void setExtentTest(ExtentTest test) {
        extenttest.set(test);
    }
    /**
	 * Calling remove method on ThreadLocal variable ensures to set the default value to ThreadLocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Jeeva Chandhran
	 * Jeeva Chandhran
	 */
    static void unExtentTest(){
        extenttest.remove();
    }

}
