package com.base;

import org.openqa.selenium.WebDriver;

public class DriverContext {
    private static Browser _browser;
    private static WebDriver _driver;

    // getter and setter for _browser
    public static Browser getBrowser() {
        return _browser;
    }

    public static void setBrowser(Browser browser) {
        _browser = browser;
    }

    // getter and setter for _driver
    public static WebDriver getDriver() {
        return _driver;
    }

    public static void setDriver(WebDriver driver) {
        _driver = driver;
    }
}
