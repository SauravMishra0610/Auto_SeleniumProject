@PaginationAppTest
Feature: Create Pagination App functionality tests


  Background:
      Given User will navigate to pagination app "http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com"

  @TestCaseUI_PaginationAppLaunch  @UI_Test @Regression
  Scenario Outline: Launch Pagination App Feature
    When User Validates On pagination app page header in screen "<headerText>"
    And User validates the page title with text containing "<pageTitleText>"
    And User Validates the table header with "<PhoneValue>"
    And User Validates the table header for "<EmailValue>"
    And User Validates the table header for the "<AddressValue>"
    And User Validates the table header for id value "<IDValue>"
    And User Validates the table header title as photo "<PhotoImage>"
    And User Validates On pagination app page header title as Name "<NameValue>"
    And User Validates the pagination app page header text as Navbar "<NavBarValue>"
    And User Validated the table header top text as Home menu "<HomeMenu>"
    And User Validates the footer page notation as Previous "<PreviousValue>"
    And User Validates the placeholder text area as Search "<SearchValue>"
    And User Validates the search button for the pagination app as button "<SearchBtmValue>"
    Then User closes the browser instance

    Examples:
      |headerText|pageTitleText |PhoneValue|EmailValue|AddressValue|IDValue|PhotoImage|NameValue|NavBarValue|HomeMenu|PreviousValue|SearchValue|SearchBtmValue|
      |Users List|Pagination App|Phone     |Email     |Address     |ID     |Photo     |Name     |Navbar     |Home    |Previous     |Search     |Button        |


  @TestCaseUI_PaginationApplicationFooter  @UI_Test @Regression
  Scenario Outline: Validate Footer header items ccc
    When User Validates On pagination app page header in screen "<headerText>"
    And User Validates the footer page notation as Previous "<PreviousValue>"
    And User Validates the button present in pagination app as next button "<NextButton>"
#    And User Validate the page pointer for pagination app as pointer  "<PagePointer>"
    And User Validates the page pointer for pagination app as next element

    Examples:
    |headerText  |PreviousValue  |NextButton|
    |Users List  |Previous       |Next      |


  @TestCaseUI_PaginationApplicationSearchByText  @UI_Test @Regression
  Scenario: Check search functionality
    When User enter search keyword and click on search button



#  @TestCaseAPI_PaginationAppLaunch @API_Test @Regression
#  Scenario Outline: Test GET Http request in Pagination App as Response for validations
#    Given User will assert params after hitting base uri for pagination app "<paginationAppURL>"
#
#    Examples:
#      |paginationAppURL                                       |
#      |http://userpaginationapp.us-east-1.elasticbeanstalk.com|