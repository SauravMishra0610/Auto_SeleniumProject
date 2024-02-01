@GoogleRegistration
Feature: Create Google Registration

  @TestCase_PositiveRegistration
  Scenario Outline: Create Google Registration Functionality
    Given User will navigate to Google mail screen "<googleURL>"
    When User Validates On Google mail screen "<expectedText>"
    And User clicks on Create Account Button
    And User selects For Myself option
    And User enter First name text field as "<FirstName>"
    And User enter Last name text field as "<LastName>"
#    And User enters its preferred Username as "<UserName>"
#    And User enters its password as "<Password>"
#    And User enters its confirm Password as "<Password>"
    And User clicks on Next Button
#    And User enters Phone number as "<PhoneNumber>"
#    And User clicks on Next Button
#    And User waits and enters otp value as "<MobileOtp>"
#    And User clicks on Verify Button
    And User enters date of its birth as "<day>"
    And User enters month of its birth as "<month>"
    And User enters year of its birth as "<year>"
    And User enters its Gender value as "<gender>"
    And User clicks on Next Button
#    Then User verifies presence of Yes I am In Button in Page
    And User will close the driver or browser

    Examples:
      |googleURL            |FirstName   |LastName    |UserName      |Password|PhoneNumber|expectedText        |day|month    |year|gender|
      |https://www.gmail.com|DellHpLenovo|LenovoHpDell|Zxasjhgfdcv56 |45&^%$sd|8797876181 |to continue to Gmail|17 |September|2001|Male  |

