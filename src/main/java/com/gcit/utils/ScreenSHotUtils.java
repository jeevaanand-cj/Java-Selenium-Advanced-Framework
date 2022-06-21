package com.gcit.utils;

import com.gcit.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

/**
 * Utility to take base64 screenshot.
 * @author Jeeva Chandhran
 * May 30, 2022 
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.listeners.ListenerClass
 */
public final class ScreenSHotUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
    private ScreenSHotUtils(){}
    
    /**
	 * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
	 * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
	 * a new method. It is advisable to use this method for many reasons.
	 * 
	 * @author Jeeva Chandhran
	 * May 30, 2022 
	 * @return Image in the form of Base64 String which can be appended directly to report
	 */
    public static String getBase64Image(){
		SessionId sessionId = ((RemoteWebDriver)DriverManager.getThreaddriver()).getSessionId();
		System.out.println(sessionId);
        return ((TakesScreenshot) DriverManager.getThreaddriver()).getScreenshotAs(OutputType.BASE64);
    }
}
