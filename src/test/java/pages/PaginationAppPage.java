package pages;

import com.google.inject.Inject;
import io.netty.buffer.ByteBufProcessor;
import org.checkerframework.checker.lock.qual.EnsuresLockHeld;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SeleniumHelper;

import javax.print.DocFlavor;
import java.time.Duration;
import java.util.List;

public class PaginationAppPage {

    public static WebDriver driver;
    public Select select;

    @Inject
    public SeleniumHelper seleniumHelper;

    public static void assertIDColumnName(String id) {
        Assert.assertEquals(id, driver.findElement(By.xpath("//*[text()='ID']")).getText());
    }

    public static void assertPreviousPageNotation(String previous) {
        WebElement Page = driver.findElement(By.xpath("//nav/ul/li[1]/a/span[contains(text,Previous)]"));
        if (Page.isEnabled()) {
            Page.getText();
        }
    }


    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    public void launchPaginationAppBaseUrl(String baseUrl) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        waitForPageToLoad();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(baseUrl);
        waitForPageToLoad();
    }

    public void assertPageHeaderText(String expectedText) throws InterruptedException {
        Thread.sleep(5000);
        String actualText = driver.findElement(By.xpath("//h3[text()='Users List']")).getText();
        seleniumHelper.assertCurrentText(expectedText.trim(), actualText.trim());
    }

    public void assertPageTitleText(String expectedText) {
        String actualText = driver.getTitle().trim();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    public void quitBrowserInstance() {
        driver.quit();
    }

    public void assertTheColumnName(String phone) {
        Assert.assertEquals(phone, driver.findElement(By.xpath("//*[text()='Phone']")).getText());
    }

    public void assertEmailColumnName(String email) {
        Assert.assertEquals(email, driver.findElement(By.xpath("//*[text()='Email']")).getText());
    }

    public void assertAddressColumnName(String address) {
        Assert.assertEquals(address, driver.findElement(By.xpath("//*[text()='Address']")).getText());
    }

    public void assertPhotoPictureColumnName(String photo) {
        Assert.assertEquals(photo, driver.findElement(By.xpath("//*[text()='Photo']")).getText());
    }

    public void assertPersonNameColumnName(String name) {
        Assert.assertEquals(name, driver.findElement(By.xpath("//*[text()='Name']")).getText());
    }

    public void assertNavigationBarColumnName(String navbar) {
        Assert.assertEquals(navbar, driver.findElement(By.xpath("//div/a[text()='Navbar']")).getText());
    }

    public void assertHomeMenuColumnName(String home) {
        Assert.assertEquals(home, driver.findElement(By.xpath("//div/ul/li/a[text()='Home']")).getText());
    }


    public void assertSearchTextAreaColumnName(String search) {
        Assert.assertEquals(search, driver.findElement(By.xpath("//input[@placeholder='Search users']")).getText());
    }

    public void assertSearchPlace(String search) {
        WebElement Placeholder = driver.findElement(By.xpath("//form/input[@placeholder='Search users']"));
        Placeholder.getAttribute("placeholder");
        System.out.println(Placeholder);
    }

    public void assertSearchButton(String button) {
        WebElement btm = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        btm.getText();
        System.out.println(btm);
    }

    public void assertNextButton(String next) {
        WebElement N = driver.findElement(By.xpath("//li/a/span[1][contains(text(),'Next')]"));
        N.getText();
        System.out.println(N);
    }

//    public void assertPageLinkPointer(String pointer) {
//        List<WebElement> Page = driver.findElements(By.xpath("//nav/ul/li[2]/a[@class='page-link]"));
//        int i = 0;
//        while (i < Page.size()) {
//            i++;
//        }
//        System.out.println(Page);
//    }

    public void assertPageItemlink() throws Exception{

        List<WebElement> Page = driver.findElements(By.xpath("//nav/ul[@class='pagination justify-content-end']/li/a"));
        for (int i = 3; i <= Page.size()-1; i++) {
            WebElement element = driver.findElement(By.xpath("//nav/ul[@class='pagination justify-content-end']/li[" + i + "]/a")); // dynamic xapth // accessding order
            element.click();
            Thread.sleep(1500);
        }
        for (int i = 10 ; i >= 2; i--) {
            WebElement element = driver.findElement(By.xpath("//nav/ul[@class='pagination justify-content-end']/li[" + i + "]/a")); // dynamic xapth // decending order
            element.click();
            Thread.sleep(1500);
        }
    }

    public void searchByNameText() throws Exception {
        Thread.sleep(5000);
        String expectedName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        WebElement searchInputBox = driver.findElement(By.xpath("//input[@name='name']"));
        searchInputBox.sendKeys(expectedName);
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();
        s

    }
}




