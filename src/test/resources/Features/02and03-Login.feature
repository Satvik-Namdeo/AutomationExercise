Feature: Login Page with credentials

  Background: 
    Given User is in home page
    When user clicks on signup/login button
    Then user is redirected to login page

  @Valid
  Scenario Outline: Login with valid credentials
    When user enters valid "<email>" and "<password>"
    And user clicks on Login button
    Then user has successfully logged in
    And Logged in as username message is displayed
    And user clicks on logout button

    Examples: 
      | email            | password  |
      | david1@gmail.com | david@123 |

  @Invalid
  Scenario Outline: Login with invalid credentials
    When user enters invalid "<email>" and "<password>"
    And User click on Login button
    Then Your email or password is incorrect! is visible

    Examples: 
      | email            | password  |
      | davod1@gmail.com | david@    |
