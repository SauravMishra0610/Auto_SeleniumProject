package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GoogleRegistrationPage;

import static com.utilities.SeleniumUtil.driver;

public class GoogleRegistrationStepDefs {

    @Inject
    public GoogleRegistrationPage googleRegistrationPage;

    @Given("^User will navigate to Google mail screen \"([^\"]*)\"$")
    public void userWillNavigateToGoogleMailScreen(String baseUrl) throws InterruptedException {
        googleRegistrationPage.launchGmailBaseURLForRegistration(baseUrl);
    }

    @When("^User Validates On Google mail screen \"([^\"]*)\"$")
    public void userValidatesOnGoogleMailScreen(String expectedText) {
        googleRegistrationPage.userValidatesGmailPage(expectedText);
    }

    @And("^User clicks on Create Account Button")
    public void userClicksOnCreateAccountButton() throws InterruptedException {
        googleRegistrationPage.userClicksOnCreateAccountButton();
    }

    @And("^User selects For Myself option")
    public void userSelectsForMyselfOption() throws InterruptedException {
        googleRegistrationPage.userSelectsForMySelfOption();
    }

    @And("^User enter First name text field as \"([^\"]*)\"$")
    public void userEnterFirstNameTextFieldAs(String firstName) {
        googleRegistrationPage.userEntersFirstName(firstName);
    }

    @And("^User enter Last name text field as \"([^\"]*)\"$")
    public void userEnterLastNameTextFieldAs(String lastName) {
        googleRegistrationPage.userEntersLastName(lastName);
    }

    @And("^User enters its preferred Username as \"([^\"]*)\"$")
    public void userEntersItsPreferredUsernameAs(String userName) {
        googleRegistrationPage.userEntersUserName(userName);
    }

    @And("^User enters its password as \"([^\"]*)\"$")
    public void userEntersItsPasswordAs(String password) {
        googleRegistrationPage.userEntersPassword(password);
    }

    @And("^User enters its confirm Password as \"([^\"]*)\"$")
    public void userEntersItsConfirmPasswordAs(String confirmPassword) {
        googleRegistrationPage.userConfirmsPassword(confirmPassword);
    }

    @And("^User clicks on Next Button")
    public void userClicksOnNextButton() throws InterruptedException {
        googleRegistrationPage.userClicksOnNextButton();
    }

    @And("^User enters Phone number as \"([^\"]*)\"$")
    public void userEntersPhoneNumberAs(String phoneNumber) throws InterruptedException {
        Thread.sleep(5000);
        googleRegistrationPage.userEntersPhoneNumber(phoneNumber);
    }

    @And("^User waits and enters otp value as \"([^\"]*)\"$")
    public void userWaitsAndEntersOtpValueAs(String phoneOTP) throws InterruptedException {
        Thread.sleep(20000);
        googleRegistrationPage.userEntersOtpFromMobile(phoneOTP);
    }

    @And("^User clicks on Verify Button")
    public void userClicksOnVerifyButton() throws InterruptedException {
        googleRegistrationPage.userClicksOnVerifyButton();
    }

    @And("^User enters date of its birth as \"([^\"]*)\"$")
    public void userEntersDateOfItsBirthAs(String birthDay) throws InterruptedException {
        googleRegistrationPage.userEntersItsBirthDay(birthDay);
    }

    @And("^User enters year of its birth as \"([^\"]*)\"$")
    public void userEntersYearOfItsBirthAs(String birthYear) {
        googleRegistrationPage.userEntersItsBirthYear(birthYear);
    }

    @And("^User enters its Gender value as \"([^\"]*)\"$")
    public void userEntersItsGenderValueAs(String gender) {
        googleRegistrationPage.userEntersItsGender(gender);
    }

    @Then("^User verifies presence of Yes I am In Button in Page")
    public void userVerifiesPresenceOfYesIAmInButtonInPage() {
        googleRegistrationPage.userVerifiesPresenceOfButton();
    }

    @And("^User enters month of its birth as \"([^\"]*)\"$")
    public void userEntersMonthOfItsBirthAs(String birthMonth) {
        googleRegistrationPage.userEntersBirthMonth(birthMonth);
    }

    @And("User will close the driver or browser")
    public void userWillCloseTheDriverOrBrowser() {
        googleRegistrationPage.userClosesBrowser();
    }


}
