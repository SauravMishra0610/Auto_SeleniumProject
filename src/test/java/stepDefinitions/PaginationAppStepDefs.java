package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.PaginationAppPage;

public class PaginationAppStepDefs {

    @Inject
    public PaginationAppPage paginationAppPage;

    public Response response;
    public RequestSpecification request;
    public String jsonString;
    public int theStatusCode;
    public String theStatus;
    public int theTotalUsersCount;
    public int theTotalPages;
    public int theSize;
    public int theNumberOfElements;

    @Given("^User will navigate to pagination app \"([^\"]*)\"$")
    public void userWillNavigateToPaginationApp(String baseUrl) throws InterruptedException {
        paginationAppPage.launchPaginationAppBaseUrl(baseUrl);
    }

    @When("^User Validates On pagination app page header in screen \"([^\"]*)\"$")
    public void userValidatesOnPaginationAppPageHeaderInScreen(String headerText) throws InterruptedException {
        paginationAppPage.assertPageHeaderText(headerText);
    }

    @And("^User validates the page title with text containing \"([^\"]*)\"$")
    public void userValidatesThePageTitleWithTextContaining(String pageTitleText) throws InterruptedException {
        paginationAppPage.assertPageTitleText(pageTitleText);
    }

    @Then("^User closes the browser instance$")
    public void userClosesTheBrowserInstance() {
        paginationAppPage.quitBrowserInstance();
    }

    @Given("^User will assert params after hitting base uri for pagination app \"([^\"]*)\"$")
    public void userWillAssertParamsAfterHittingBaseUriForPaginationApp(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        response = request.get("/users?name=&page=0&size=10");

        jsonString = response.asString();

        // Assert on Status Code
        theStatusCode = JsonPath.from(jsonString).get("statusCode");
        Assert.assertEquals(theStatusCode, 200);

        // Assert On Status Message
        theStatus = JsonPath.from(jsonString).get("status");
        Assert.assertEquals(theStatus, "200 OK");

        // Assert On Total Elements On Http.GET request
        theTotalUsersCount = JsonPath.from(jsonString).get("data.page.totalElements");
        Assert.assertEquals(theTotalUsersCount, 100);

        // Assert On Total Pages On Http.GET request
        theTotalPages = JsonPath.from(jsonString).get("data.page.totalPages");
        Assert.assertEquals(theTotalPages, 10);

        // Assert On Size On Http.GET request
        theSize = JsonPath.from(jsonString).get("data.page.size");
        Assert.assertEquals(theSize, 10);

        // Assert On Number Of Elements On Http.GET request
        theNumberOfElements = JsonPath.from(jsonString).get("data.page.numberOfElements");
        Assert.assertEquals(theNumberOfElements, 10);

        // Assert On Any User Name On Http.GET request
        String userName = JsonPath.from(jsonString).get("data.page.content[0].name");
        Assert.assertTrue(userName.contains("Royce".trim()));

        // Assert On Any Email On Http.GET request
        String userEmail = JsonPath.from(jsonString).get("data.page.content[5].email");
        Assert.assertTrue(userEmail.contains("mbaildon5@census.gov".trim()));

    }

    @And("^User Validates the table header with \"([^\"]*)\"$")
    public void userValidatesTheTableHeaderWith(String phone) {
        paginationAppPage.assertTheColumnName(phone);
    }

    @And("^User Validates the table header for \"([^\"]*)\"$")
    public void userValidatesTheTableHeaderFor(String email) {

        paginationAppPage.assertEmailColumnName(email);
    }

    @And("^User Validates the table header for the \"([^\"]*)\"$")
    public void userValidatesTheTableHeaderForThe(String address) {
        paginationAppPage.assertAddressColumnName(address);
    }

    @And("^User Validates the table header for id value \"([^\"]*)\"$")
    public void userValidatesTheTableHeaderForIdValue(String ID) {
        PaginationAppPage.assertIDColumnName(ID);
    }


    @And("^User Validates the table header title as photo \"([^\"]*)\"$")
    public void userValidatesTheTableHeaderTitleAsPhoto(String photo) {
        paginationAppPage.assertPhotoPictureColumnName(photo);
    }

    @And("^User Validates On pagination app page header title as Name \"([^\"]*)\"$")
    public void userValidatesOnPaginationAppPageHeaderTitleAsName(String name) {
        paginationAppPage.assertPersonNameColumnName(name);
    }

    @And("^User Validates the pagination app page header text as Navbar \"([^\"]*)\"$")
    public void userValidatesThePaginationAppPageHeaderTextAsNavbar(String navbar) {
        paginationAppPage.assertNavigationBarColumnName(navbar);
    }


    @And("^User Validated the table header top text as Home menu \"([^\"]*)\"$")
    public void userValidatedTheTableHeaderTopTextAsHomeMenu(String home) {
        paginationAppPage.assertHomeMenuColumnName(home);

    }

    @And("^User Validates the footer page notation as Previous \"([^\"]*)\"$")
    public void userValidatesTheFooterPageNotationAsPrevious(String previous) {
        PaginationAppPage.assertPreviousPageNotation(previous);
    }

    @And("^User Validates the placeholder text area as Search \"([^\"]*)\"$")
    public void userValidatesThePlaceholderTextAreaAsSearch(String search) {
        paginationAppPage.assertSearchPlace(search);

    }

    @And("^User Validates the search button for the pagination app as button \"([^\"]*)\"$")
    public void userValidatesTheSearchButtonForThePaginationAppAsButton(String button) {
        paginationAppPage.assertSearchButton(button);
    }

    @And("^User Validates the button present in pagination app as next button \"([^\"]*)\"$")
    public void userValidatesTheButtonPresentInPaginationAppAsNextButton(String next) {
        paginationAppPage.assertNextButton(next);
    }


//    @And("^User Validate the page pointer for pagination app as pointer  \"([^\"]*)\"$")
//    public void userValidateThePagePointerForPaginationAppAsPointer(String pointer) {
//       paginationAppPage.assertPageLinkPointer(pointer);
//    }


    @And("^User Validates the page pointer for pagination app as next element$")
    public void userValidatesThePagePointerForPaginationAppAsNextElement() throws Exception {
        paginationAppPage.assertPageItemlink();
    }

    @When("^User enter search keyword and click on search button$")
    public void userEnterSearchKeywordAndClickOnSearchButton() throws Exception {
        paginationAppPage.searchByNameText();

    }
}




