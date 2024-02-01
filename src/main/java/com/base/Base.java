package com.base;

import org.openqa.selenium.support.PageFactory;

public class Base {
    public static BasePage currentPage;

    public <ObjectPage extends BasePage> ObjectPage getInstance(Class<ObjectPage> page) {
        // PageFactory Class:
        // - extension to the Page Object design pattern
        // - is required to use annotations: @FindBy

        Object obj = PageFactory.initElements(DriverContext.getDriver(), page);
        return page.cast(obj);
    }
}
