package com.gcit.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.*;

import static com.gcit.utils.JsonUtils.generateTestDataJson;
import static com.gcit.utils.JsonUtils.getTestDataDetails;

/**
 * Holds the data provider for all the test cases in the framework.
 * 
 * May 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0
 */
public final class DataProviderUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
    private DataProviderUtils(){}

    private static List<Map<String, Object>> testDataFromJson = new ArrayList();

    /**
	 * Acts as a data provider for all the test cases.
	 * 
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 * @version 1.0
	 * @since 1.0<br>
	 * @see com.gcit.tests;
	 * @see com.gcit.listeners.AnnotationTransformer
	 */
    @DataProvider(name = "getJsonTestData")
    public static Object[] getJsonData(Method method) {
        String testName = method.getName();
        List<Map<String, Object>> iterationList = new ArrayList();
        if (testDataFromJson.isEmpty()) {
            //get the data from database
            generateTestDataJson();
            //Store the test details in list
            testDataFromJson = getTestDataDetails();
        }


        for (int i = 0; i < testDataFromJson.size(); i++) {
            if (String.valueOf(testDataFromJson.get(i).get("testcasename")).equalsIgnoreCase(testName) &&
                    String.valueOf(testDataFromJson.get(i).get("execute")).equalsIgnoreCase("yes")) {
                iterationList.add(testDataFromJson.get(i));
            }

        }
        // remove duplicates from the previous list to avoid unwanted run from data provider
        Set<Map<String, Object>> set = new HashSet(iterationList);
        iterationList.clear();
        iterationList.addAll(set);
        return iterationList.toArray();
    }

}
