package com.gcit.driver;

import com.gcit.enums.ConfigProperties;
import com.gcit.exceptions.FrameWorkExceptions;
import com.gcit.factories.DriverFactory;
import com.gcit.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 *  Driver class is responsible for invoking and closing the browsers.
 *  <p>
 *  It's also responsible for setting the driver variable to driver manager
 *  which handles the thread safety for the webdriver instance.
 *  </p>
 *  @author Jeeva Chandhran
 *  May 26, 2022
 *  @version 1.0
 *  @since 1.0 <br>
 *  @see DriverManager
 *  @see com.gcit.Base.BaseSetup
 */


public final class Driver {
    /**
     * Private constructor to avoid external instantiation
     */
    private Driver() {
    }

    /**
     * @author Jeeva Chandhran
     * @param browserName passed from the {@link com.gcit.Base.BaseSetup} test class. Value will be chrome and edge
     * @return It returns current webdriver instance based on the browsername
     */
    public static void initDriver(String browserName) {
        try {
            DriverManager.setThreaddriver(DriverFactory.getDriver(browserName));
        } catch (MalformedURLException e) {
            throw new FrameWorkExceptions("Browser invocation failed, please check capabilities");
        }
    }
    /**
	 * Terminates the browser instance.
	 * Sets the thread-local to default value, i.e null.
	 * @author Jeeva Chandhran
	 * May 26, 2022
	 */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getThreaddriver())) {
            DriverManager.getThreaddriver().quit();
            DriverManager.unloadDriver();
        }

    }

    /**
     * Close the browser instance.
     * @author Jeeva Chandhran
     * May 26, 2022
     */
    public static void closeDriver() {
        if (Objects.nonNull(DriverManager.getThreaddriver())) {
            DriverManager.getThreaddriver().close();
        }

    }
}
