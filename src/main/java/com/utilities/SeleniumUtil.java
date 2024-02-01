package com.utilities;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SeleniumUtil {
    public static WebDriver driver;

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prash\\IdeaProjects\\CucumberBDDFrameworks\\browserdrivers\\chromedriver");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public void waitForPageToLoad(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
    });
    }


    public void enter(WebElement element){
        try
        {
            waitForElementVisibility(element);
            element.click();
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void enterText(WebElement element,String inputText){
        try
        {
            waitForElementVisibility(element);
            element.sendKeys(inputText);
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void waitForElementVisibility(WebElement element){
        try
        {
            WebDriverWait w = new WebDriverWait(driver, 5);
            w.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element is visible");
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void launchURL(String url){
        driver.get(url);
    }

    public void refreshPage(){

        driver.navigate().refresh();
    }

}
