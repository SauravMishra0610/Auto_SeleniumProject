package com.base;

import org.openqa.selenium.WebDriver;

public class Browser extends Base {
    private WebDriver _driver;

    public Browser(WebDriver driver) {
        _driver = driver;
    }

    public void goUrl(String url) {
        _driver.get(url);
    }

    public void maximize() {
        _driver.manage().window().maximize();
    }
}
